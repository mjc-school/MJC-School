package com.epam.esm.mapper;


import com.epam.esm.Tag;
import com.epam.esm.dto.CertificateDto;
import com.epam.esm.dto.TagDto;

import java.util.List;


public interface TagDtoMapper {
    public Tag changeTagDtoToTag(TagDto tagDto);
    public List<Tag> changeCertificateDtoToTagList(CertificateDto dto);


}
