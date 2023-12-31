package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class BusinessNumberNotFoundException extends RuntimeException {

    private static final String MESSAGE = "해당 비즈니스 번호를 가진 출판사가 없습니다.";

    public BusinessNumberNotFoundException ( String businessNumber ) {
        super(MESSAGE + " 비즈니스 번호 " + businessNumber);
    }
}
