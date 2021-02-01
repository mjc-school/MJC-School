package com.epam.esm.dao.impl;

import com.epam.esm.dao.CertificateDao;
import com.epam.esm.entity.GiftCertificate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CertificateDaoTest {
    private EmbeddedDatabase embeddedDatabase;

    private JdbcTemplate jdbcTemplate;

    private CertificateDao certificateDao;

    private GiftCertificate giftCertificate = new GiftCertificate("Spa-comlex", "Spa-complex for 1 person for 3 hours", new BigDecimal(150), 40, LocalDateTime.of(2021, 01, 20, 13, 06, 22), LocalDateTime.of(2021, 01, 20, 13, 06, 22));

    @BeforeEach
    public void setUp() {
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/db/mydb.sql")
                .build();
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);
        certificateDao = new CertificateDaoImpl(jdbcTemplate);
    }

    @Test
    void findAllCertificates() {
        List<GiftCertificate> list = certificateDao.findAllCertificates();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(4, list.size());
    }

    @Test
    void findCertificateById() {
        long id = 3;
        GiftCertificate certificate = certificateDao.findCertificateById(id);
        Assertions.assertNotNull(certificate);
        Assertions.assertEquals(id, certificate.getId());
    }

    @Test
    void findCertificateByIdWrong() {
        long id = 31254;
        GiftCertificate certificate = certificateDao.findCertificateById(id);
        Assertions.assertNull(certificate);
    }

    @Test
    void createNewCertificate() {
        Integer id = certificateDao.createNewCertificate(giftCertificate);
        Assertions.assertNotNull(id);
        Assertions.assertEquals(5, id);
    }

    @Test
    void updateCertificate() {
        long id = 3;
        Integer number = certificateDao.updateCertificate(giftCertificate, id);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(1, number);
        Assertions.assertEquals(giftCertificate.getName(), certificateDao.findCertificateById(id).getName());
    }

    @Test
    void updateCertificateWrongId() {
        long id = 3456;
        Integer number = certificateDao.updateCertificate(giftCertificate, id);
        Assertions.assertEquals(0, number);
      }

    @Test
    void deleteCertificate() {
        long id = 2;
        Integer number = certificateDao.deleteCertificate(id);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(1, number);

    }

    @Test
    void deleteCertificateWrongId() {
        long id = 221548;
        Integer number = certificateDao.deleteCertificate(id);
        Assertions.assertNotNull(number);
        Assertions.assertEquals(0, number);

    }

    @Test
    void findCertificatesByTag() {
        String tag = "sport";
        List<GiftCertificate> list = certificateDao.findCertificatesByTag(tag);
        Assertions.assertNotNull(list);
        Assertions.assertEquals(2, list.size());

        String wrongTag = "carmen";
        List<GiftCertificate> wrongList = certificateDao.findCertificatesByTag(wrongTag);
        Assertions.assertNotNull(wrongList);
        Assertions.assertTrue(wrongList.isEmpty());
    }

    @Test
    void findCertificatesOrderedByNameAsc() {
        List<GiftCertificate> list = certificateDao.findCertificatesOrderedByNameAsc();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(list.get(0).getId(), 3);
        Assertions.assertEquals(list.get(list.size()-1).getId(), 2);
    }
}