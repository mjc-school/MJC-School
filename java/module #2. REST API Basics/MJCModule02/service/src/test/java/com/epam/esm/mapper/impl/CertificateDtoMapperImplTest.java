package com.epam.esm.mapper.impl;

import com.epam.esm.GiftCertificate;
import com.epam.esm.Tag;
import com.epam.esm.dto.CertificateDto;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CertificateDtoMapperImplTest {
    private List<Tag> tagList = Arrays.asList(new Tag("dance"), new Tag("active"));
    private CertificateDto dto = new CertificateDto("Dancing", "Dancing cource", new BigDecimal(150)
            , 40, tagList);
    private GiftCertificate giftCertificate = new GiftCertificate("Dancing", "Dancing cource", new BigDecimal(150)
            , 40);

    CertificateDtoMapperImpl mapper = new CertificateDtoMapperImpl();

    @Test
    void changeDtoToCertificate() {
        GiftCertificate certificate = mapper.changeDtoToCertificate(dto);
        Assertions.assertNotNull(certificate);
        Assertions.assertEquals(dto.getName(), certificate.getName());
    }

    @Test
    void changeCertificateToDto() {
        CertificateDto newDto = mapper.changeCertificateToDto(giftCertificate, tagList);
        Assertions.assertEquals(dto, newDto);
    }
}