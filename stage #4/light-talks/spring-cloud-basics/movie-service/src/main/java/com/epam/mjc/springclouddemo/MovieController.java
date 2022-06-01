package com.epam.mjc.springclouddemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final RestTemplate restTemplate;

    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public Movie getMovie() {
        final String actorUrl = "http://actor-service/actors";
        final String directorUrl = "http://director-service/directors";

        Director director = restTemplate.getForObject(directorUrl, Director.class);
        List<Actor> actors = Arrays.asList(restTemplate.getForObject(actorUrl, Actor[].class)).stream().collect(Collectors.toList());
        final Movie movie = new Movie();
        movie.setName("Inception");
        movie.setDirector(director);
        movie.setActors(actors);

        return movie;
    }
}
