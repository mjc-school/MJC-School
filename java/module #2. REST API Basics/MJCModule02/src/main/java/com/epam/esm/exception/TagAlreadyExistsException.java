package com.epam.esm.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;


public class TagAlreadyExistsException extends RuntimeException {
    private String code;

    public TagAlreadyExistsException(CustomErrorCode code) {
        this.code = code.getCode();
    }

    public TagAlreadyExistsException(String message, CustomErrorCode code) {
        super(message);
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }
}
