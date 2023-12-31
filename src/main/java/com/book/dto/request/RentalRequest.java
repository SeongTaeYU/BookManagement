package com.book.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/12
 */

@ToString
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class RentalRequest {
    private Long bookId;
    private Long userId;

    @Builder
    public RentalRequest ( Long bookId, Long userId ) {
        this.bookId = bookId;
        this.userId = userId;
    }
}
