package com.epam.mjc.springclouddemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @GetMapping
    public Director getDirector() {
        return new Director("Steven", "Speilberg", "USA");
    }
}
