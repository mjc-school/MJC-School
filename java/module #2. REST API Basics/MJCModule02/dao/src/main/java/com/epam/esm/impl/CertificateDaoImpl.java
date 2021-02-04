package com.epam.esm.impl;

import com.epam.esm.CertificateDao;
import com.epam.esm.GiftCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component

public class CertificateDaoImpl implements CertificateDao {
    public static final String SQL_QUERY_READ_CERTIFICATES_LIST = "Select * from gift_certificate;";
    public static final String SQL_QUERY_READ_ONE_CERTIFICATE = "select * from gift_certificate where id = ?";
    public static final String SQL_QUERY_INSERT_CERTIFICATE = "insert into gift_certificate (name, description, price" +
            ", duration, create_date, last_update_date) values (?, ?, ?, ?, ?, ?);";
    public static final String SQL_QUERY_UPDATE_CERTIFICATE = "update gift_certificate set name=?, description=?" +
            ", price=?, duration=?, create_date=?, last_update_date=? where id = ?;";
    public static final String SQL_QUERY_DELETE_CERTIFICATE = "delete from gift_certificate where id = ?;";
    public static final String SQL_QUERY_FIND_CERTIFICATES_BY_TAG = "select gc.* from gift_certificate gc join gift_certificate_has_tag gct on gc.id=gct.gift_certicicate_id_gift_certicicate join tag t on t.id=gct.tag_id_tag where t.nameTag like ? order by gc.id;";
    public static final String SQL_QUERY_CERTIFICATES_LIST_ORDER_BY_NAME = "Select * from gift_certificate order by name;";
    public static final String DB_PROCEDURE_CALL = "call DescriptionNameSearch(?);";
    public static final String MAP_KEY_NAME_PROCEDURE = "#result-set-1";

    private final JdbcTemplate template;

    @Autowired
    public CertificateDaoImpl(JdbcTemplate template) {
        this.template = template;
    }


    public List<GiftCertificate> findAllCertificates() {
        List<GiftCertificate> certificateList = template.query(SQL_QUERY_READ_CERTIFICATES_LIST
                , new BeanPropertyRowMapper<>(GiftCertificate.class));
        return certificateList;
    }


    public GiftCertificate findCertificateById(long id) {
        GiftCertificate certificate = template.query(SQL_QUERY_READ_ONE_CERTIFICATE
                , new Object[]{id}, new BeanPropertyRowMapper<>(GiftCertificate.class))
                .stream().findAny().orElse(null);

        return certificate;
    }

    public Integer createNewCertificate(GiftCertificate certificate) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SQL_QUERY_INSERT_CERTIFICATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, certificate.getName());
            ps.setString(2, certificate.getDescription());
            ps.setBigDecimal(3, certificate.getPrice());
            ps.setInt(4, certificate.getDuration());
            ps.setTimestamp(5, Timestamp.valueOf(certificate.getCreateDate()));
            ps.setTimestamp(6, Timestamp.valueOf(certificate.getLastUpdateDate()));
            return ps;

        }, generatedKeyHolder);

        Integer key = (generatedKeyHolder.getKey()).intValue();
        return key;
    }

    public Integer updateCertificate(GiftCertificate updatedCertificate, long id) {

        int fildsNumber = template.update(SQL_QUERY_UPDATE_CERTIFICATE, updatedCertificate.getName(), updatedCertificate.getDescription()
                , updatedCertificate.getPrice(), updatedCertificate.getDuration(), updatedCertificate.getCreateDate()
                , updatedCertificate.getLastUpdateDate(), id);

        return  fildsNumber;

    }

    public Integer deleteCertificate(long id) {
       Integer deleteFields =  template.update(SQL_QUERY_DELETE_CERTIFICATE, id);
       return  deleteFields;

    }

    @Override
    public List<GiftCertificate> findCertificatesByTag(String tagName) {
         List<GiftCertificate> resultList = template.query(
                SQL_QUERY_FIND_CERTIFICATES_BY_TAG, new Object[]{tagName}
                , new RowMapper<GiftCertificate>() {
                    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
                        GiftCertificate c = new GiftCertificate();
                        c.setId(rs.getLong(1));
                        c.setName(rs.getString(2));
                        c.setDescription(rs.getString(3));
                        c.setPrice(rs.getBigDecimal(4));
                        c.setDuration(rs.getInt(5));
                        c.setCreateDate(rs.getTimestamp(6).toLocalDateTime());
                        c.setLastUpdateDate(rs.getTimestamp(7).toLocalDateTime());
                        return c;
                    }
                });

        return resultList;
    }

    public List<GiftCertificate> findCertificatesOrderedByNameAsc(){
        List<GiftCertificate> certificateList = template.query(SQL_QUERY_CERTIFICATES_LIST_ORDER_BY_NAME
                , new BeanPropertyRowMapper<>(GiftCertificate.class));
        return certificateList;
    }

    public List<GiftCertificate> findCertificatesByNameOrDescriptionPart(String namePart) {
        List<GiftCertificate> certificateList = new ArrayList<>();
        Map<String, Object> out = searchCertificatesWithTags(namePart);

        List<Map<String, Object>> results = (List<Map<String, Object>>) out.get(MAP_KEY_NAME_PROCEDURE);

        results.stream().forEach(c -> {
            GiftCertificate ct = new GiftCertificate();
            ct.setId((int) c.get("id"));
            ct.setName((String) c.get("name"));
            ct.setDescription((String) c.get("description"));
            ct.setPrice((BigDecimal) c.get("price"));
            ct.setDuration((Integer)c.get("duration"));
            ct.setCreateDate(((Timestamp) c.get("create_date")).toLocalDateTime());
            ct.setLastUpdateDate(((Timestamp)c.get("last_update_date")).toLocalDateTime());
            certificateList.add(ct);
        });

        return certificateList;
    }


    private Map<String, Object> searchCertificatesWithTags(String namePart) {
        List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR));
        return template.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement cs = con.prepareCall(DB_PROCEDURE_CALL);
                cs.setString(1, namePart);
                return cs;
            }
        }, parameters);
    }

}
