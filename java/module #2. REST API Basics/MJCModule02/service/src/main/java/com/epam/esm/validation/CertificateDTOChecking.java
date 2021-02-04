package com.epam.esm.validation;


import com.epam.esm.dto.CertificateDto;

import java.math.BigDecimal;

public class CertificateDTOChecking {

    public static String chechCertificateDtoFormat(CertificateDto dto) {
        String resultString = null;

        if (dto.getName() == null || dto.getName().length() < 3 || dto.getName().length() >32) {
            resultString = "The certificate name could be between 3 and 20 symbols";
        } else if (dto.getDescription() == null || dto.getDescription().length() < 5 || dto.getDescription().length() > 100) {
            resultString = "Description could be between 5 and 100 symbols";
        } else if (dto.getPrice() == null || dto.getPrice().compareTo(new BigDecimal("0")) < 0) {
            resultString = "Enter certificate price";
        } else if (dto.getDuration() == null || dto.getDuration().compareTo(Integer.parseInt("1")) < 0){
            resultString = "Enter certificate duration more than 1 day";
        } else if (dto.getTagList() == null || dto.getTagList().size() == 0) {
            resultString = "Enter at least 1 certificate tags";
        }

        return  resultString;
    }
}
