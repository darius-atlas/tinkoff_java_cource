package ru.tinkoff.edu.java.bot.configuration.Response;

import java.util.List;

public class ApiErrorResponse {
    private String description;
    private String code;
    private String exceptionName;
    private String exceptionMessage;
    private List<String> stacktrace;

    public <T> ApiErrorResponse(String badRequest, String errorCode, String simpleName, String message, List<T> singletonList) {

    }

    public ApiErrorResponse(String simpleName, String message, List<StackTraceElement> asList) {

    }

    public ApiErrorResponse() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public List<String> getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(List<String> stacktrace) {
        this.stacktrace = stacktrace;
    }
}

