package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class BookStockCountZeroException extends RuntimeException {
    private static final String MESSAGE = "도서 재고개수가 0개 입니다.";
    public BookStockCountZeroException () {
        super(MESSAGE);
    }
}
