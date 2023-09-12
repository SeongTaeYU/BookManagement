package com.book.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/12
 */

@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class BookUpdateRequest {

    private String title;
    private String bookIntroduction;
    private String thumbnailUrl;

    @Builder
    public BookUpdateRequest ( String title, String bookIntroduction, String thumbnailUrl ) {
        this.title = title;
        this.bookIntroduction = bookIntroduction;
        this.thumbnailUrl = thumbnailUrl;
    }
}
