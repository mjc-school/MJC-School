package com.epam.esm.entity;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;


@ResponseBody
public class Tag {
    private long id;
    private String nameTag;

    public Tag() {
    }

    public Tag(String name) {
        this.nameTag = name;
    }


    public Tag(long id, String nameTag) {
        this.id = id;
        this.nameTag = nameTag;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        Tag tag = (Tag) o;
        return id == tag.id && Objects.equals(nameTag, tag.nameTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameTag);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + nameTag + '\'' +
                '}';
    }
}
