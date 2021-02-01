package com.epam.esm.dao.impl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.dao.impl.TagDaoImpl;
import com.epam.esm.entity.Tag;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.exception.TagAlreadyExistsException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TagDaoImplTest {
    private EmbeddedDatabase embeddedDatabase;

    private JdbcTemplate jdbcTemplate;

    private TagDao tagDao;

    @BeforeEach
    public void setUp() {
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/db/mydb.sql")
                .build();
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);
        tagDao = new TagDaoImpl(jdbcTemplate);
    }

    @Test
    void testFindAllTagList() {
        Assertions.assertNotNull(tagDao.findAllTagList());
        Assertions.assertEquals(6, tagDao.findAllTagList().size());
    }

    @Test
    void testFindTag() {
        Assertions.assertNotNull(tagDao.findTag("spa"));
        Assertions.assertNull(tagDao.findTag("lalala"));
    }

    @Test
    void testFindTag1() {
        Assertions.assertNotNull(tagDao.findTag(1));
        Assertions.assertNull(tagDao.findTag(130));
    }

    @Test
    void testAddNewTag() {
        Tag tag = tagDao.addNewTag(new Tag(7, "swimming"));
        Assertions.assertNotNull(tag);
        Assertions.assertNotNull(tag.getId());
        Assertions.assertEquals(tag, new Tag(7, "swimming"));

    }

    @Test
    void testDeleteTag() {
        long id = 4;
        Integer number = tagDao.deleteTag(id);
        Assertions.assertNotNull(number);
        Assertions.assertNull(tagDao.findTag(id));
        Assertions.assertEquals(1, number);

        long idWrong = 2145;
        Integer numberWrong = tagDao.deleteTag(idWrong);
        Assertions.assertEquals(0, numberWrong);
    }

    @Test
    void testFindTagsByCertificateId() {
        long certIdWrong = 52;
        List<Tag> tagList = tagDao.findTagsByCertificateId(certIdWrong);
        Assertions.assertNotNull(tagList);
        Assertions.assertTrue(tagList.isEmpty());
    }

    @AfterEach
    public void endTest() {

        embeddedDatabase.shutdown();
    }
}
