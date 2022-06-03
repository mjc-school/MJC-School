package com.epam.mjc.springclouddemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @GetMapping
    public List<Actor> getActors() {

        return List.of(new Actor("Brad", "Pitt", 50),
                new Actor("Matt", "Daymon", 55));
    }
}
