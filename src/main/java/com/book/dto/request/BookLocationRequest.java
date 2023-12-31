package com.book.dto.request;

import com.book.entity.BookLocation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/12
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class BookLocationRequest {

    private String categoryName;
    private String locationCode;

    public BookLocation toEntity () {
        return BookLocation.builder()
            .categoryName(categoryName)
            .locationCode(locationCode)
            .build();
    }
}