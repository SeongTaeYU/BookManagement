package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class BookNotFoundException extends RuntimeException {

    private static final String MESSAGE = "해당 ID의 도서를 조회할 수 없습니다.";

    public BookNotFoundException ( Long id ) {
        super(MESSAGE + "  도서 ID: " + id);
    }
}
