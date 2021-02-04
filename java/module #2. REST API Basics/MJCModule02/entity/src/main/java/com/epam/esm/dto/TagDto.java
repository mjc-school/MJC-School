package com.epam.esm.dto;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@ResponseBody
public class TagDto {
    private long idTag;
    private String nameTag;

    public TagDto() {
    }

    public TagDto(String nameTag) {
        this.nameTag = nameTag;
    }

    public TagDto(long idTag, String nameTag) {
        this.idTag = idTag;
        this.nameTag = nameTag;
    }

    public long getIdTag() {
        return idTag;
    }

    public void setIdTag(long idTag) {
        this.idTag = idTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDto tagDto = (TagDto) o;
        return idTag == tagDto.idTag && nameTag == tagDto.nameTag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTag, nameTag);
    }

    @Override
    public String toString() {
        return "TagDto{" +
                "idTag=" + idTag +
                ", nameTag=" + nameTag +
                '}';
    }
}
