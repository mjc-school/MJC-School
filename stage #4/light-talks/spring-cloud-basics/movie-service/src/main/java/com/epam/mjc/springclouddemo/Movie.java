package com.epam.mjc.springclouddemo;

import java.util.List;

public class Movie {

    private Integer id;
    private String name;
    private int issueYear;
    private List<Actor> actors;
    private Director director;

    public Movie() {
    }

    public Movie(Integer id, String name, int issueYear, List<Actor> actors, Director director) {
        this.id = id;
        this.name = name;
        this.issueYear = issueYear;
        this.actors = actors;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
