package com.epam.esm.exception;

import com.epam.esm.util.CustomErrorCode;

public class NoSuchResourceException extends RuntimeException {
    private String code;

    public NoSuchResourceException(CustomErrorCode code) {
        this.code = code.getCode();
    }

    public NoSuchResourceException(String message, CustomErrorCode code) {
        super(message);
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }
}
