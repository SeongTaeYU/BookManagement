package com.book.exception.handler;

import com.book.dto.response.ErrorResponse;
import com.book.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */

@Slf4j
@RestControllerAdvice
public class UserExceptionHandler {

    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException ( UserNotFoundException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
