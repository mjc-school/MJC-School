package com.epam.light.talk.reactive.demo2;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class EmployeeService {

    public Mono<Employee> getById(int id) {
        Employee employee = new Employee()
                .setId(id).setName(id + "-name");
        return Mono.just(employee)
                .delayElement(Duration.ofMillis(3_000));
    }
}
