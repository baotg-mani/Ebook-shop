package com.cmcglobal.ebshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e, WebRequest req) {
        // Log err

        return new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "duplicate record!")
    public ErrorResponse handleDuplicateException(DuplicateException e, WebRequest req) {
        // Log err

        return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    /* Xử lý Exception.class chung nếu không chạy vào các custom Exception
    (coi như đây là phần system Exception, cần che dấu đi error bên trong) */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "system error!")
    public ErrorResponse handleSystemException(Exception e, WebRequest req) {
        // Log err

        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "server error!");
    }
}
