package com.epam.light.talk.reactive.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeById(@PathVariable int id) {
        Mono<Employee> mono = employeeService.getById(id);
        System.out.println("Mono assembled " +  mono);
        return mono;
    }

}