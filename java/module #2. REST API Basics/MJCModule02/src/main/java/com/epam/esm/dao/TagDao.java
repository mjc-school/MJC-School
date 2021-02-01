package com.epam.esm.dao;

import com.epam.esm.entity.Tag;
import org.springframework.stereotype.Component;

import java.util.List;


public interface TagDao {
    public List<Tag> findAllTagList();
    public Tag findTag(long id);
    public Tag findTag(String name);
    public Tag addNewTag(Tag tag);
    public Integer deleteTag(long id);
    public List<Tag> findTagsByCertificateId(long certificateId);

}
