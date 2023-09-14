package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class NotExistEmailException extends RuntimeException {
    private static final String MESSAGE = "존재 하지 않는 이메일 입니다.";
    public NotExistEmailException ( String email ) {
        super(MESSAGE);
    }
}
