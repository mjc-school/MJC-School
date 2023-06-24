package org.example.exceptions;

public class EmployeeNotFoundException extends Exception{
    EmployeeNotFoundException(String message) {
        super(message);
    }
}
