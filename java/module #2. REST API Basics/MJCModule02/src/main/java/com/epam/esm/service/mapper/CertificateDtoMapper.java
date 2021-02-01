package com.epam.esm.service.mapper;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.CertificateDto;
import com.epam.esm.entity.Tag;

import java.util.List;


public interface CertificateDtoMapper {
    public GiftCertificate changeDtoToCertificate(CertificateDto dto);

    public CertificateDto changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList);




}
