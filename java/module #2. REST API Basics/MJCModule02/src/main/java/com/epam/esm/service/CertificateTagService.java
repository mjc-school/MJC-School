package com.epam.esm.service;

import com.epam.esm.dao.CertificateTagDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.CertificateDto;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.mapper.CertificateDtoMapper;
import com.epam.esm.service.mapper.TagDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CertificateTagService {

    private final CertificateDtoMapper certificateMapper;
    private final TagDtoMapper tagDtoMapper;
    private final CertificateService certificateService;
    private final TagService tagService;
    private final CertificateTagDao certificateTagDao;

    @Autowired
    public CertificateTagService(CertificateDtoMapper certificateMapper, TagDtoMapper tagDtoMapper, CertificateService certificateService, TagService tagService, CertificateTagDao certificateTagDao) {
        this.certificateMapper = certificateMapper;
        this.tagDtoMapper = tagDtoMapper;
        this.certificateService = certificateService;
        this.tagService = tagService;
        this.certificateTagDao = certificateTagDao;
    }


    public Integer createNewCertificateWithTags(CertificateDto dto) {
        GiftCertificate certificate = certificateMapper.changeDtoToCertificate(dto);
        long certificateId = certificateService.createNewCertificate(certificate);

        List<Tag> tagList = tagDtoMapper.changeCertificateDtoToTagList(dto);

        Integer resultField = 0;

        for (Tag tag : tagList) {
            long tagId = 0;
            if (tagService.findTag(tag.getNameTag()) == null) {
                tagId = tagService.addNewTag(tag).getId();

            } else {
                tagId = tagService.findTag(tag.getNameTag()).getId();
            }

            resultField += certificateTagDao.createNewCertificateTagRelation(certificateId, tagId);


        }
        return resultField;
    }
}




