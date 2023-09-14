package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class AlreadyExistBookException extends RuntimeException {

    private static final String MESSAGE = "이미 존재하는 도서 코드 입니다.";

    public AlreadyExistBookException ( String bookCode ) {
        super(MESSAGE + " 도서 코드: " + bookCode);
    }

}
