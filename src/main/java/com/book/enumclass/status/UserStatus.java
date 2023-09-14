package com.book.enumclass.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {

    REGISTER(1, "회원 등록 상태"),
    UNREGISTER(2, "회원 해지 상태");

    private final int userId;
    private final String description;
}
