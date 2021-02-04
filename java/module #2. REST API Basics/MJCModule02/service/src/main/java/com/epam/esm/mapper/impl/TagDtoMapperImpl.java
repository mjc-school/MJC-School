package com.epam.esm.mapper.impl;

import com.epam.esm.Tag;
import com.epam.esm.dto.CertificateDto;
import com.epam.esm.dto.TagDto;
import com.epam.esm.mapper.TagDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDtoMapperImpl implements TagDtoMapper {
    @Override
    public Tag changeTagDtoToTag(TagDto tagDto) {
        Tag tag = new Tag(tagDto.getIdTag(), tagDto.getNameTag());
        return tag;
    }


    @Override
    public List<Tag> changeCertificateDtoToTagList(CertificateDto dto) {
         List<Tag> tagList = dto.getTagList();
        return tagList;
    }
}
