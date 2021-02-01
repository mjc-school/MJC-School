package com.epam.esm.service.mapper;

import com.epam.esm.entity.dto.CertificateDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.dto.TagDto;

import java.util.List;


public interface TagDtoMapper {
    public Tag changeTagDtoToTag(TagDto tagDto);
    public List<Tag> changeCertificateDtoToTagList(CertificateDto dto);


}
