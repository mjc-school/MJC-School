package com.epam.esm.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public class ExceptionDetails {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime time;
    private int errorStatus;
    private String errorMessage;
    private String errorCode;

    public ExceptionDetails() {
    }

    public ExceptionDetails(LocalDateTime time, int errorStatus, String errorMessage, String errorCode) {
        this.time = time;
        this.errorStatus = errorStatus;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
