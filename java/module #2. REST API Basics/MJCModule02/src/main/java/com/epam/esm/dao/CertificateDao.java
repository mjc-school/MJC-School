package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;

import java.util.List;

public interface CertificateDao {
    public List<GiftCertificate> findAllCertificates();
    public GiftCertificate findCertificateById(long id);
    public Integer createNewCertificate(GiftCertificate certificate);
    public Integer updateCertificate(GiftCertificate certificate, long id);
    public Integer deleteCertificate(long id);
    public List<GiftCertificate> findCertificatesByTag(String tagName);
    public List<GiftCertificate> findCertificatesOrderedByNameAsc();
    public List<GiftCertificate> findCertificatesByNameOrDescriptionPart(String namePart);

}
