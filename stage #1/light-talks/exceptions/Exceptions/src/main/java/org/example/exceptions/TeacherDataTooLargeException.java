package org.example.exceptions;

public class TeacherDataTooLargeException extends RuntimeException{
    TeacherDataTooLargeException(String message){
        super(message);
    }
}
