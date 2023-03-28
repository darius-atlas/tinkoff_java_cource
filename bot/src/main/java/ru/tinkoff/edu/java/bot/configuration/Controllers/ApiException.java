package ru.tinkoff.edu.java.bot.configuration.Controllers;

public class ApiException extends RuntimeException {

    private String errorCode;

    public ApiException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}

