package com.epam.esm.mapper;


import com.epam.esm.GiftCertificate;
import com.epam.esm.Tag;
import com.epam.esm.dto.CertificateDto;

import java.util.List;


public interface CertificateDtoMapper {
    public GiftCertificate changeDtoToCertificate(CertificateDto dto);

    public CertificateDto changeCertificateToDto(GiftCertificate certificate, List<Tag> tagList);




}
