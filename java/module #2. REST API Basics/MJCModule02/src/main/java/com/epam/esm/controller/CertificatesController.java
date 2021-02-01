package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.dto.CertificateDto;
import com.epam.esm.exception.CustomErrorCode;
import com.epam.esm.exception.GeneralException;
import com.epam.esm.exception.InvalidDataException;
import com.epam.esm.exception.NoSuchResourceException;
import com.epam.esm.service.CertificateService;
import com.epam.esm.service.CertificateTagService;
import com.epam.esm.service.validation.CertificateDTOChecking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificatesController {
    private final CertificateService certificateService;
    private final CertificateTagService certificateTagService;

    public CertificatesController(CertificateService certificateService, CertificateTagService certificateTagService) {
        this.certificateService = certificateService;
        this.certificateTagService = certificateTagService;
    }

    @GetMapping()
    public List<GiftCertificate> findAllCertificates() {
        List<GiftCertificate> fullCertificateList = certificateService.findAllCertificates();
        return fullCertificateList;
    }

    @GetMapping("/{id}")
    public GiftCertificate findCertificateById(@PathVariable("id") long id) {
        GiftCertificate certificate = certificateService.findCertificateById(id);
        if (certificate == null) {
            throw new NoSuchResourceException(CustomErrorCode.CERTIFICATE);
        }
        return certificate;
    }

    @PostMapping()
    @ResponseBody
    public Integer createNewCertificate(@RequestBody CertificateDto certificateDto) {
        String dtoChecking = CertificateDTOChecking.chechCertificateDtoFormat(certificateDto);
        if (dtoChecking != null) {
            throw  new InvalidDataException(dtoChecking, CustomErrorCode.CERTIFICATE);
        }
       Integer id =  certificateTagService.createNewCertificateWithTags(certificateDto);
       return  id;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Integer updateCertificate(@RequestBody GiftCertificate certificate, @PathVariable("id") long id) throws GeneralException {
        Integer updatesNumber = certificateService.updateCertificate(certificate, id);

        if (updatesNumber == null) {
            throw  new NoSuchResourceException(CustomErrorCode.CERTIFICATE);
        }
        return updatesNumber;
    }

    @DeleteMapping("/{id}")
    public Integer deleteCertificate(@PathVariable("id") int id) {
        Integer deleteFields = certificateService.deleteCertificate(id);
        if (deleteFields == null || deleteFields == 0) {
            throw  new NoSuchResourceException(CustomErrorCode.CERTIFICATE);
        }
        return deleteFields;
    }

    @GetMapping("/tag={tagName}")
    public List<CertificateDto> findCertificatesByTag(@PathVariable("tagName") String tagName) {
        List<CertificateDto> certificateList = certificateService.findCertificatesByTagName(tagName);
        if (certificateList.isEmpty()) {
            throw new NoSuchResourceException(CustomErrorCode.CERTIFICATE);
        }
        return certificateList;
    }

    @GetMapping("/sort_by=name(asc)")
    public List<CertificateDto> sortCertificatesByNameAsc() {
        List<CertificateDto> certificateList = certificateService.sortAllCertificatesByNameAsc();
        return certificateList;
    }


    @GetMapping("/name={namePart}")
    public List<CertificateDto> findAllCertificatesWithTagsByNameOrDescriptionPart(@PathVariable("namePart") String namePart) {
        List<CertificateDto> certificateList = certificateService.findAllCertificatesByNameDescriptionPart(namePart);
        return certificateList;
    }


}


