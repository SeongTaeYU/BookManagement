package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class UserNotFoundException extends RuntimeException{
    private static final String MESSAGE = "해당 Id의 사용자를 찾을 수 없습니다.";
    public UserNotFoundException (Long id) {
        super(MESSAGE + " ID: " + id );
    }
}
