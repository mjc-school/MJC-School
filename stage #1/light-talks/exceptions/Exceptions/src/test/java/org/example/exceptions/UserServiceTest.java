package org.example.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testGetCustomerByName_whenEmployeeDoesNotExcist_throwsEmployeeNotFoundException(){
        EmployeeNotFoundException exception = assertThrows(EmployeeNotFoundException.class,
                () -> userService.getCustomerByName("DummyName"),
                "EmployeeNotFoundException was expected");
        assertEquals("Employee With Given Name not Found", exception.getMessage());
    }
}