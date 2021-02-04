package com.epam.esm;

import com.epam.esm.dto.CertificateDto;
import com.epam.esm.mapper.CertificateDtoMapper;
import com.epam.esm.mapper.TagDtoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CertificateTagServiceTest {
    @Mock
    private  CertificateDtoMapper certificateMapper;
    @Mock
    private  TagDtoMapper tagDtoMapper;
    @Mock
    private  CertificateService certificateService;
    @Mock
    private  TagService tagService;
    @Mock
    private  CertificateTagDao certificateTagDao;
    @InjectMocks
    private CertificateTagService certificateTagService;

    @Test
    void createNewCertificateWithTags() {
        List<Tag> tagList = Arrays.asList(new Tag("dance"), new Tag("active"));
        CertificateDto dto = new CertificateDto( "Twist", "Twist Cource for 2 persons for a month", new BigDecimal(100), 40, tagList);
        GiftCertificate certificate = new GiftCertificate( "Twist", "Twist Cource for 2 persons for a month", new BigDecimal(100), 40);

        Mockito.when(certificateMapper.changeDtoToCertificate(dto)).thenReturn(certificate);
        Mockito.when(certificateService.createNewCertificate(certificate)).thenReturn(1);
        Mockito.when(tagDtoMapper.changeCertificateDtoToTagList(dto)).thenReturn(tagList);
        Mockito.when(tagService.findTag(tagList.get(0).getNameTag())).thenReturn(null);
        Mockito.when(tagService.findTag(tagList.get(1).getNameTag())).thenReturn(null);
        Mockito.when(certificateTagDao.createNewCertificateTagRelation(1, 1L)).thenReturn(1);
        Mockito.when(certificateTagDao.createNewCertificateTagRelation(1, 2L)).thenReturn(1);

        Integer number = certificateTagService.createNewCertificateWithTags(dto);

        Assertions.assertNotNull(number);
        Assertions.assertEquals(2, number);
    }

}