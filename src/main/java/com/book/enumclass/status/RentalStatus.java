package com.book.enumclass.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RentalStatus {
    RENTAL(0, "도서 대여 상태"),
    RETURN(1, "도서 반납 상태"),
    NON_RETURN(2, "미반납 상태");

    private final int rentalId;
    private final String description;
}