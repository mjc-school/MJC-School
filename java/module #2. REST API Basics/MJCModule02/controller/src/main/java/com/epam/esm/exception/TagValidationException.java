package com.epam.esm.exception;

import com.epam.esm.util.CustomErrorCode;

public class TagValidationException extends RuntimeException {

    private String code;

    public TagValidationException(CustomErrorCode code) {
        this.code = code.getCode();
    }

    public TagValidationException(String message, CustomErrorCode code) {
        super(message);
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }
}


