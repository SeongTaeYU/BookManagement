package com.book.exception.handler;

import com.book.dto.response.ErrorResponse;
import com.book.exception.AlreadyExistCategoryException;
import com.book.exception.AlreadyExistPublisherException;
import com.book.exception.CategoryNotFoundException;
import com.book.exception.BusinessNumberNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (AlreadyExistCategoryException.class)
    public ErrorResponse handleAlreadyExistCategoryException ( AlreadyExistCategoryException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (AlreadyExistPublisherException.class)
    public ErrorResponse handleAlreadyExistPublisherException (
        AlreadyExistPublisherException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (BusinessNumberNotFoundException.class)
    public ErrorResponse handlePublisherNotFoundException ( BusinessNumberNotFoundException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (CategoryNotFoundException.class)
    public ErrorResponse handleCategoryNotFoundException ( CategoryNotFoundException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException (
        MethodArgumentNotValidException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getFieldError());
    }

    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (RuntimeException.class)
    public ErrorResponse handleRuntimeException ( RuntimeException ex ) {
        log.error("서버 장애 로그 >>> { }", ex);
        return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 장애가 발생했습니다.");
    }

}
