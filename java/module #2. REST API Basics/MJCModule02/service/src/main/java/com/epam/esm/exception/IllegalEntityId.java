package com.epam.esm.exception;

import com.epam.esm.util.CustomErrorCode;

public class IllegalEntityId extends RuntimeException {
    private String code;

    public IllegalEntityId(CustomErrorCode code) {
        this.code = code.getCode();
    }

    public IllegalEntityId(String message, CustomErrorCode code) {
        super(message);
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }
}
