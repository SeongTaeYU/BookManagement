package com.book.dto.request;

import java.time.LocalDate;

import com.book.entity.Book;
import com.book.entity.BookLocation;
import com.book.entity.Category;
import com.book.entity.Publisher;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/12
 */

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class BookSaveRequest {

    private Long categoryId;
    private String locationCode;
    private String bookCode;
    private String title;
    private String bookIntroduction;
    private String author;
    private String thumbnail;
    private String publisherBusinessNumber;
    private LocalDate publicationAt;

    public Book createNewBook ( Category category, Publisher publisher, BookLocation bookLocation ) {
        return Book.builder()
            .bookCode(bookCode)
            .title(title)
            .bookIntroduction(bookIntroduction)
            .author(author)
            .thumbnail(thumbnail)
            .publicationAt(publicationAt)
            .category(category)
            .publisher(publisher)
            .bookLocation(bookLocation)
            .build();
    }
}
