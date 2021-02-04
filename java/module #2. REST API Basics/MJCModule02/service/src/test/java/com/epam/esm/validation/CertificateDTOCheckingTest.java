package com.epam.esm.validation;

import com.epam.esm.Tag;
import com.epam.esm.dto.CertificateDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CertificateDTOCheckingTest {
    private List<Tag> tagList = Arrays.asList(new Tag("dance"), new Tag("active"));
    private CertificateDto dto = new CertificateDto("Dancing", "Dancing cource", new BigDecimal(150)
            , 40, tagList);

    @Test
    public  void chechCertificateDtoFormat() {
        String resultList = CertificateDTOChecking.chechCertificateDtoFormat(dto);
        Assertions.assertNull(resultList);
    }

    @Test
    public  void chechCertificateDtoFormatWrongName() {
        String wrongName = "The certificate name could be between 3 and 20 symbols";
        dto.setName("ty");
        String resultString = CertificateDTOChecking.chechCertificateDtoFormat(dto);
        Assertions.assertNotNull(resultString);
        Assertions.assertEquals(wrongName, resultString);
    }

    @Test
    public  void chechCertificateDtoFormatWrongDescription() {
        String wrongDescription = "Description could be between 5 and 100 symbols";
        dto.setDescription("ty");
        String resultString = CertificateDTOChecking.chechCertificateDtoFormat(dto);
        Assertions.assertNotNull(resultString);
        Assertions.assertEquals(wrongDescription, resultString);
    }

    @Test
    public  void chechCertificateDtoFormatWrongPrice() {
        String wrongPrice = "Enter certificate price";
        dto.setPrice(new BigDecimal(-45));
        String resultString = CertificateDTOChecking.chechCertificateDtoFormat(dto);
        Assertions.assertNotNull(resultString);
        Assertions.assertEquals(wrongPrice, resultString);
    }

    @Test
    public  void chechCertificateDtoFormatWrongDuration() {
        String wrongDuration = "Enter certificate duration more than 1 day";
        dto.setDuration(0);
        String resultString = CertificateDTOChecking.chechCertificateDtoFormat(dto);
        Assertions.assertNotNull(resultString);
        Assertions.assertEquals(wrongDuration, resultString);
    }

    @Test
    public  void chechCertificateDtoFormatWrongTagList() {
        String noTagList = "Enter at least 1 certificate tags";
        dto.setTagList(null);
        String resultString = CertificateDTOChecking.chechCertificateDtoFormat(dto);
        Assertions.assertNotNull(resultString);
        Assertions.assertEquals(noTagList, resultString);
    }

}