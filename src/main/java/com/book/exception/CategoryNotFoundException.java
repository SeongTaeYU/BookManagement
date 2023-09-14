package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */

public class CategoryNotFoundException extends RuntimeException {

    private static final String MESSAGE = "해당 ID를 가진 Category 가 없습니다.";

    public CategoryNotFoundException ( Long categoryId ) {
        super(MESSAGE + "카테고리 ID:" + categoryId);
    }
}
