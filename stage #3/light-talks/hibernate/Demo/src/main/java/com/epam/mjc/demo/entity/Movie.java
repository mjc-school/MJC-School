package com.epam.mjc.demo.entity;

import org.springframework.util.CollectionUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column
    private BigDecimal budget;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_actor",
               joinColumns = @JoinColumn(name = "movie_id"),
               inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors;

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

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        if (CollectionUtils.isEmpty(this.actors)) {
            this.actors = new HashSet<>();
        }
        this.actors.add(actor);
    }

    @Override
    public String toString() {
        String actorString = null;
        if (!CollectionUtils.isEmpty(this.actors)) {
            actorString = actors.stream()
                    .map(Actor::getLastName)
                    .collect(Collectors.joining(", "));
        }
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", issueDate=" + issueDate +
                ", budget=" + budget +
                ", company=" + company +
                ", actors=" + actorString +
                '}';
    }
}
