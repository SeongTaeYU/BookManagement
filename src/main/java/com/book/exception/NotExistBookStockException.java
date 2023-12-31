package com.book.exception;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */
public class NotExistBookStockException extends RuntimeException {
    private static final String MESSAGE = "더 이상 제고가 없습니다.";

    public NotExistBookStockException ( Long bookId, int stockCount ) {
        super(MESSAGE + " 도서 ID: " + bookId + " 재고 개수: " + stockCount);
    }
}
