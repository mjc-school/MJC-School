package com.example.qualitygates.dto;

import java.time.LocalDate;

public class UserDTO {

    private String name;

    private LocalDate date;

    public UserDTO(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

}
