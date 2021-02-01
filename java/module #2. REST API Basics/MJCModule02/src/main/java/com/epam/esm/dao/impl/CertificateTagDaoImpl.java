package com.epam.esm.dao.impl;

import com.epam.esm.dao.CertificateTagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class CertificateTagDaoImpl implements CertificateTagDao {
    public static final String SQL_QUERY_INSERT_CERTIFICATE_TAG_RELATION = "insert into gift_certificate_has_tag (gift_certicicate_id_gift_certicicate, tag_id_tag) values (?, ?) ";


    private final JdbcTemplate template;

    @Autowired
    public CertificateTagDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Integer createNewCertificateTagRelation(long certificateId, long tagId) {
        Integer updatedField = template.update(SQL_QUERY_INSERT_CERTIFICATE_TAG_RELATION, certificateId, tagId);
        return  updatedField;

    }

}
