package com.book.enumclass.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PublisherStatus {

    REGISTER(1, "계약 등록 상태"),
    UNREGISTER(2, "계약 해지 상태");

    private final int publisherId;
    private final String description;
}
