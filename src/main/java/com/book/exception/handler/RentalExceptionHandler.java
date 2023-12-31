package com.book.exception.handler;

import com.book.dto.response.ErrorResponse;
import com.book.exception.NotExistBookStockException;
import com.book.exception.RentalNotFoundException;
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
public class RentalExceptionHandler {

    /**
     * 도서 재고 개수가 0 인 예외
     */
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (NotExistBookStockException.class)
    public ErrorResponse handleNotExistBookStockException ( NotExistBookStockException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     *  잘못된 대여 ID 예외
     */
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    @ExceptionHandler (RentalNotFoundException.class)
    public ErrorResponse handleRentalNotFoundException ( RentalNotFoundException ex ) {
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
