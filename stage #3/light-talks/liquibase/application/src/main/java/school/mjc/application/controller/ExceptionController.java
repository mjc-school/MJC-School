package school.mjc.application.controller;


import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import school.mjc.application.exception.UserNotFoundException;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFoundException(UserNotFoundException unfe){
        log.error(unfe.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User doesn’t exist with given id.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity internalException(Exception e){
        log.error(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Internal server error occurred.");
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity validationException(ValidationException ve){
        log.error(ve.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Internal server error occurred.");
    }
}
