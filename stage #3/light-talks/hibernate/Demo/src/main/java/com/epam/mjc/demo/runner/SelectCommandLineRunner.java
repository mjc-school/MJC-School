package com.epam.mjc.demo.runner;

import com.epam.mjc.demo.common.IdSaver;
import com.epam.mjc.demo.entity.Movie;
import com.epam.mjc.demo.repository.ActorRepository;
import com.epam.mjc.demo.repository.CompanyRepository;
import com.epam.mjc.demo.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Order(2)
public class SelectCommandLineRunner implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final CompanyRepository companyRepository;
    private final IdSaver idSaver;

    public SelectCommandLineRunner(MovieRepository movieRepository,
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
    public void run(String... args) {
        System.out.println("Starting select entities...");

//        4, 5
//        System.out.println(actorRepository.findById(idSaver.getIdByName("Di Caprio")));
//        System.out.println(movieRepository.findById(idSaver.getIdByName("Inception")));

//        6.1
//        List<Movie> movies = movieRepository.findJPQL();
//        movies.forEach(System.out::println);

//        6.3
        //List<Movie> movies = movieRepository.findJPQLLeftJoinFetch();
        //movies.forEach(System.out::println);

//        9
//        List<Movie> movies = movieRepository.findWithOffsetAndLimit(1, 2);
//        movies.forEach(System.out::println);


        System.out.println("Finishing select entities...");
    }




}
