package com.epam.esm.exception;

import com.epam.esm.util.CustomErrorCode;

public class GeneralException extends Exception{
    private String code;

    public GeneralException(String message, CustomErrorCode code) {
        super(message);
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }
}
