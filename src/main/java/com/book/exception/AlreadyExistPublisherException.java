package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class AlreadyExistPublisherException extends RuntimeException {

    private static final String MESSAGE = "이미 존재하는 출판사 입니다.";

    public AlreadyExistPublisherException ( String businessNumber ) {
        super(MESSAGE + " 사업자 번호: " + businessNumber);
    }
}
