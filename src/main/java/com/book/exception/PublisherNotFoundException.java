package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class PublisherNotFoundException extends RuntimeException {
    private static final String MESSAGE = "해당 ID 의 출판사가 존재하지 않습니다.";

    public PublisherNotFoundException () {
        super(MESSAGE);
    }
}
