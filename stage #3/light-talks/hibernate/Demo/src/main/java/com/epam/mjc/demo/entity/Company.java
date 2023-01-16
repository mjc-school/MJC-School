package com.epam.mjc.demo.entity;

import org.springframework.util.CollectionUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String country;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Movie> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (CollectionUtils.isEmpty(this.movies)) {
            this.movies = new ArrayList<>();
        }
        this.movies.add(movie);
    }

    @Override
    public String toString() {
        String movieString = null;
        if (!CollectionUtils.isEmpty(this.movies)) {
            movieString = movies.stream()
                    .map(Movie::getName)
                    .collect(Collectors.joining());
        }
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", movies=" + movieString +
                '}';
    }
}
