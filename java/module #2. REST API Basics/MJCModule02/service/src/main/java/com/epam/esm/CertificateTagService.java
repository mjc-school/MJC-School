package com.epam.esm;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.exception.TagAlreadyExistsException;
import com.epam.esm.mapper.CertificateDtoMapper;
import com.epam.esm.mapper.TagDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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


    public Integer createNewCertificateWithTags(CertificateDto dto)  {
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




