package com.epam.mjc.demo.runner;

import com.epam.mjc.demo.common.IdSaver;
import com.epam.mjc.demo.entity.Actor;
import com.epam.mjc.demo.entity.Company;
import com.epam.mjc.demo.entity.Movie;
import com.epam.mjc.demo.repository.ActorRepository;
import com.epam.mjc.demo.repository.CompanyRepository;
import com.epam.mjc.demo.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Order(1)
public class CreateCommandLineRunner implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final CompanyRepository companyRepository;
    private final IdSaver idSaver;

    public CreateCommandLineRunner(MovieRepository movieRepository,
                                   ActorRepository actorRepository,
                                   CompanyRepository companyRepository,
                                   IdSaver idSaver) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.companyRepository = companyRepository;
        this.idSaver = idSaver;
    }

    @Override
    @Transactional
    public void run(String... args) throws IOException {
        System.out.println("Starting create entities...");

        // 1
        System.out.println("Creating movies...");
        final Movie darkKnight = createMovie("Dark knight", BigDecimal.valueOf(120000L), LocalDate.of(2008, 8, 8));
        movieRepository.create(darkKnight);
        final Movie inception = createMovie("Inception", BigDecimal.valueOf(140000L), LocalDate.of(2010, 10, 10));
        movieRepository.create(inception);
        final Movie interstellar = createMovie("Interstellar", BigDecimal.valueOf(160000L), LocalDate.of(2014, 11, 11));
        movieRepository.create(interstellar);
        final Movie dunkirk = createMovie("Dunkirk", BigDecimal.valueOf(200000L), LocalDate.of(2017, 7, 7));
        movieRepository.create(dunkirk);

        System.out.println("Creating actors...");
        final Actor hardi = createActor("Tom", "Hardi", 42);
        actorRepository.create(hardi);
        final Actor diCaprio = createActor("Leonardo", "Di Caprio", 47);
        actorRepository.create(diCaprio);
        final Actor cotillard = createActor("Marion", "Cotillard", 45);
        actorRepository.create(cotillard);
        final Actor kayne = createActor("Michael", "Kayne", 80);
        actorRepository.create(kayne);

        System.out.println("Creating companies...");
        final Company disney = createCompany("Disney", "USA");
        companyRepository.create(disney);
        final Company netflix = createCompany("Netflix", "USA");
        companyRepository.create(netflix);
        final Company hulu = createCompany("Hulu", "England");
        companyRepository.create(hulu);

//        2
//        System.out.println(movieRepository.findById(inception.getId()));

//        3
//        movieRepository.flush();

//         4
//        System.out.println(actorRepository.findById(diCaprio.getId()));
//        diCaprio.addMovie(inception);
//        System.out.println(actorRepository.findById(diCaprio.getId()));
//        System.out.println(movieRepository.findById(inception.getId()));
//        idSaver.putPair(diCaprio.getLastName(), diCaprio.getId());
//        idSaver.putPair(inception.getName(), inception.getId());

//        5
//        System.out.println(movieRepository.findById(inception.getId()));
//        inception.addActor(diCaprio);
//        System.out.println(movieRepository.findById(inception.getId()));
//        System.out.println(actorRepository.findById(diCaprio.getId()));
//        idSaver.putPair(diCaprio.getLastName(), diCaprio.getId());
//        idSaver.putPair(inception.getName(), inception.getId());

//        6.1
//        inception.addActor(diCaprio);
//        inception.addActor(cotillard);
//        inception.addActor(hardi);
//        dunkirk.addActor(hardi);
//        dunkirk.addActor(cotillard);

//        6.2
//        final Movie memento = createMovie("Memento", BigDecimal.valueOf(20000L), LocalDate.of(2002, 7, 7));
//        movieRepository.create(memento);

//        7
//        System.out.println("Testing runtime exception...");
//        final Company sony = createCompany("Sony", "USA");
//        companyRepository.create(sony);

//        7.1
 //       dummyRuntimeException();

//        7.2
 //       dummyIOException();

//        8
//        idSaver.putPair(inception.getName(), inception.getId());

        System.out.println("Finishing create entities...");
    }

    private Movie createMovie(String name, BigDecimal budget, LocalDate date) {
        final Movie movie = new Movie();
        movie.setName(name);
        movie.setBudget(budget);
        movie.setIssueDate(date);

        return movie;
    }

    private Actor createActor(String firstName, String lastName, int age) {
        final Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setAge(age);

        return actor;
    }

    private Company createCompany(String name, String country) {
        final Company company = new Company();
        company.setName(name);
        company.setCountry(country);

        return company;
    }

    @Transactional
    void dummyRuntimeException() {
        throw new RuntimeException();
    }

    @Transactional
    void dummyIOException() throws IOException {
        throw new IOException();
    }
}
