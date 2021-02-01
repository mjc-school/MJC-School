package com.epam.esm.entity;

import java.util.Objects;

public class CertificateTagEntity {
    private long certificateId;
    private long tagId;

    public CertificateTagEntity() {
    }

    public CertificateTagEntity(long certificateId, long tagId) {
        this.certificateId = certificateId;
        this.tagId = tagId;
    }

    public long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(long certificateId) {
        this.certificateId = certificateId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateTagEntity that = (CertificateTagEntity) o;
        return certificateId == that.certificateId && tagId == that.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificateId, tagId);
    }

    @Override
    public String toString() {
        return "CertificateTagEntity{" +
                "certificateId=" + certificateId +
                ", tagId=" + tagId +
                '}';
    }
}
