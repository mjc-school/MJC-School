package com.epam.esm.mapper.impl;

import com.epam.esm.GiftCertificate;
import com.epam.esm.Tag;
import com.epam.esm.dto.CertificateDto;
import com.epam.esm.mapper.CertificateDtoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CertificateDtoMapperImpl implements CertificateDtoMapper {

    @Override
    public GiftCertificate changeDtoToCertificate(CertificateDto dto) {
        GiftCertificate certificate = new GiftCertificate(dto.getName(), dto.getDescription(), dto.getPrice()
                , dto.getDuration());
        return certificate;
    }

    @Override
    public CertificateDto changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList) {
        CertificateDto dto = new CertificateDto(certificate, tagList);
        return dto;
    }

}
