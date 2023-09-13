package com.book.enumclass.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BookStatus {

    REGISTER(1, "도서 등록 상태"),
    UNREGISTER(2, "도서 해지 상태");

    private final int bookId;
    private final String description;
}
