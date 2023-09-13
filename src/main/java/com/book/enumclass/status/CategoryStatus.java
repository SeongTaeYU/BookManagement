package com.book.enumclass.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoryStatus {
	
    REGISTER(1, "카테고리 운영 상태"),
    UNREGISTER(2, "카테고리 미운영 상태");

    private final int categoryId;
    private final String description;
	
}
