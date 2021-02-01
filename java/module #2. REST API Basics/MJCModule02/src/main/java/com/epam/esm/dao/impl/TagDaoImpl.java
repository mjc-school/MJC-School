package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class TagDaoImpl implements TagDao {
    public static final String SQL_QUERY_READ_TAG_LIST = "Select * from tag;";
    public static final String SQL_QUERY_READ_ONE_TAG_BY_ID = "select * from tag where id = ?;";
    public static final String SQL_QUERY_READ_ONE_TAG_BY_NAME = "select * from tag where nameTag like ?;";
    public static final String SQL_QUERY_INSERT_TAG = "insert into tag (nameTag) values (?);";
    public static final String SQL_QUERY_DELETE_TAG = "delete from tag where id = ?;";
    public static final String SQL_QUERY_FIND_TAGS_BY_CERTIFICATE_ID= "select t.* from tag t join gift_certificate_has_tag ct on t.id=ct.tag_id_tag join gift_certificate c on c.id=ct.gift_certicicate_id_gift_certicicate where c.id = ?;";


    private final JdbcTemplate template;

    @Autowired
    public TagDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Tag> findAllTagList() {
        List<Tag> tagList = template.query(SQL_QUERY_READ_TAG_LIST
                , new BeanPropertyRowMapper<>(Tag.class));
        return  tagList;
    }

    @Override
    public Tag findTag(long id) {
        Tag tag = template.query(SQL_QUERY_READ_ONE_TAG_BY_ID
                , new Object[]{id}, new BeanPropertyRowMapper<>(Tag.class))
                .stream().findAny().orElse(null);
        return  tag;
    }

    @Override
    public Tag findTag(String name) {
        Tag tag = template.query(SQL_QUERY_READ_ONE_TAG_BY_NAME
                , new Object[]{name}, new BeanPropertyRowMapper<>(Tag.class))
                .stream().findAny().orElse(null);
        return  tag;
    }

    @Override
    public Tag addNewTag(Tag tag) {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
           PreparedStatement ps = connection
                    .prepareStatement(SQL_QUERY_INSERT_TAG, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tag.getNameTag());
            return ps;

        }, generatedKeyHolder);

        long key = (generatedKeyHolder.getKey()).longValue();
        tag.setId(key);
        return tag;
    }

    @Override
    public Integer deleteTag(long id) {
        Integer fildsNumber = template.update(SQL_QUERY_DELETE_TAG, id);
        return fildsNumber;


    }

    @Override
    public List<Tag> findTagsByCertificateId(long certificateId) {
        List<Tag> resultList = template.query(
                SQL_QUERY_FIND_TAGS_BY_CERTIFICATE_ID, new Object[]{certificateId}
                , new RowMapper<Tag>() {
                    public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Tag c = new Tag();
                        c.setId(rs.getLong(1));
                        c.setNameTag(rs.getString(2));
                        return c;
                    }
                });

        return resultList;
    }
}
