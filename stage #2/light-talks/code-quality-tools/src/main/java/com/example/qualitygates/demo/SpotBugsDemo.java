package com.example.qualitygates.demo;

import java.time.LocalDate;

import com.example.qualitygates.dto.UserDTO;

/*
 * ./gradlew spotbugsMain
 */
public class SpotBugsDemo {

     private String foo = "foo";

    public void bar(String s) {
        String name = s.toUpperCase();
        LocalDate date = LocalDate.now();

        UserDTO userDTO = new UserDTO(name, date);
        System.out.println(userDTO);
    }

}
