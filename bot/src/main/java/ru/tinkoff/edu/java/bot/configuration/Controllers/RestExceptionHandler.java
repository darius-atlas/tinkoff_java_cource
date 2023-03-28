package ru.tinkoff.edu.java.bot.configuration.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tinkoff.edu.java.bot.configuration.Response.ApiErrorResponse;

import java.util.Collections;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {
        ApiErrorResponse error = new ApiErrorResponse(
                "Bad Request",
                ex.getErrorCode(),
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                Collections.singletonList(ex.getStackTrace()[0].toString())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

