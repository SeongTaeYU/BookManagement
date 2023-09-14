package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class RentalNotFoundException extends RuntimeException {
    private static final String MESSAGE = "해당 Id 의 대여 정보가 존재하지 않습니다.";
    public RentalNotFoundException (Long id) {
        super(MESSAGE + " 대여 Id: " + id);
    }
}
