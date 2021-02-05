package com.epam.esm;


import com.epam.esm.dto.CertificateDto;
import com.epam.esm.exception.IllegalEntityId;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.mapper.CertificateDtoMapper;
import com.epam.esm.util.CustomErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CertificateService {
    private final CertificateDao certificateDao;
    private final TagDao tagDao;
    private final CertificateDtoMapper certificateMapper;

    @Autowired
    public CertificateService(CertificateDao certificateDao, TagDao tagDao, CertificateDtoMapper certificateMapper) {
        this.certificateDao = certificateDao;
        this.tagDao = tagDao;
        this.certificateMapper = certificateMapper;
    }


    public List<GiftCertificate> findAllCertificates() {
        return certificateDao.findAllCertificates();
    }

    public GiftCertificate findCertificateById(long id) {
        GiftCertificate certificate = certificateDao.findCertificateById(id);
        return certificate;
    }

    public Integer createNewCertificate(GiftCertificate certificate) {
        LocalDateTime currentDate = LocalDateTime.now();
        certificate.setCreateDate(currentDate);
        certificate.setLastUpdateDate(currentDate);
        Integer certificateId = certificateDao.createNewCertificate(certificate);

        return certificateId;
    }

    public Integer updateCertificate(GiftCertificate certificate, long id) {
        GiftCertificate certificateFromDb = certificateDao.findCertificateById(id);
        if (certificateFromDb == null) {
            throw  new IllegalEntityId(CustomErrorCode.CERTIFICATE);
        }
        if (certificate.getName() != null) {
            certificateFromDb.setName(certificate.getName());
        }
        if (certificate.getDescription() != null) {
            certificateFromDb.setDescription(certificate.getDescription());
        }
        if (certificate.getPrice() != null) {
            certificateFromDb.setPrice(certificate.getPrice());
        }
        if (certificate.getDuration() != null) {
            certificateFromDb.setDuration(certificate.getDuration());
        }
        if (certificate.getCreateDate() != null) {
            certificateFromDb.setCreateDate(certificate.getCreateDate());
        }

        LocalDateTime currentDate = LocalDateTime.now();
        certificateFromDb.setLastUpdateDate(currentDate);

       int fildsNumber =  certificateDao.updateCertificate(certificateFromDb, id);
       return fildsNumber;
    }

    public Integer deleteCertificate(long id) {
        Integer number = certificateDao.deleteCertificate(id);
        System.out.println("deleteCertif" + number);
        if (number == null || number == 0) {
            throw  new NoSuchResourceException(CustomErrorCode.CERTIFICATE);
        }
        return number;
    }


    public List<CertificateDto> findCertificatesByTagName(String tagName) {
        List<GiftCertificate> list = certificateDao.findCertificatesByTag(tagName);
        List<CertificateDto> dtoList = createCertificateListToDto(list);
        return dtoList;
    }



    public List<CertificateDto> sortAllCertificatesByNameAsc() {
        List<GiftCertificate> certificateList = certificateDao.findCertificatesOrderedByNameAsc();
        List<CertificateDto> dtoList = createCertificateListToDto(certificateList);
        return dtoList;
    }



    public List<CertificateDto> findAllCertificatesByNameDescriptionPart(String namePart) {
        List<GiftCertificate> list = certificateDao.findCertificatesByNameOrDescriptionPart(namePart);
        List<CertificateDto> dtoList = createCertificateListToDto(list);
        return dtoList;
    }

    public List<CertificateDto> createCertificateListToDto(List<GiftCertificate> list) {
        List<CertificateDto> dtoList = new ArrayList<>();
        for (GiftCertificate certificate : list) {
            List<Tag> tagList = tagDao.findTagsByCertificateId(certificate.getId());
            dtoList.add(certificateMapper.changeCertificateToDto(certificate, tagList));
        }
        return dtoList;
    }



}

