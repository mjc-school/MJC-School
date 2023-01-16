package com.epam.mjc.demo.runner;

import com.epam.mjc.demo.common.IdSaver;
import com.epam.mjc.demo.entity.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Order(3)
public class LazyCommandLineRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    private final IdSaver idSaver;

    public LazyCommandLineRunner(IdSaver idSaver) {
        this.idSaver = idSaver;
    }

    @Override
    public void run(String... args) {
        //System.out.println("Lazy Initialization Exception...");
//        8
        //System.out.println(getMovie().getActors());
    }

    @Transactional
    Movie getMovie() {
        return entityManager.find(Movie.class, idSaver.getIdByName("Inception"));
    }
}
