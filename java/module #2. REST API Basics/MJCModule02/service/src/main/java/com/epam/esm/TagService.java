package com.epam.esm;


import com.epam.esm.dto.TagDto;
import com.epam.esm.exception.TagAlreadyExistsException;
import com.epam.esm.mapper.TagDtoMapper;
import com.epam.esm.util.CustomErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    public Tag addNewTag(TagDto tagDto) throws TagAlreadyExistsException{
        System.out.println(tagDto);
        Tag tag = tagDtoMapper.changeTagDtoToTag(tagDto);
        System.out.println("Tag" + tag);
        Tag newTag = tagDao.addNewTag(tag);

        System.out.println("tag after adding " + newTag);
        return newTag;
    }


    public Tag addNewTag(Tag tag) {
        Tag newTag = tagDao.addNewTag(tag);
        return newTag;
    }


}
