package com.epam.esm.service;

import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.dto.TagDto;
import com.epam.esm.service.TagService;
import com.epam.esm.service.mapper.TagDtoMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TagService {
    private final TagDtoMapper tagDtoMapper;
    private final TagDao tagDao;

    public TagService(TagDtoMapper tagDtoMapper, TagDao tagDao) {
        this.tagDtoMapper = tagDtoMapper;
        this.tagDao = tagDao;
    }


    public List<Tag> findAllTagList() {
        List<Tag> tagList = tagDao.findAllTagList();
        return tagList;
    }


    public Tag findTag(long id) {
        Tag tag = tagDao.findTag(id);
        return tag;
    }


    public Tag findTag(String name) {
        Tag tag = tagDao.findTag(name);
        return  tag;
    }


    public Integer deleteTag(long id) {

        Integer fieldsNumber = tagDao.deleteTag(id);
        return  fieldsNumber;
    }

    public Tag addNewTag(TagDto tagDto) {
        Tag tag = tagDtoMapper.changeTagDtoToTag(tagDto);
        Tag newTag = tagDao.addNewTag(tag);
        return newTag;
    }


    public Tag addNewTag(Tag tag) {
        Tag newTag = tagDao.addNewTag(tag);
        return newTag;
    }


}
