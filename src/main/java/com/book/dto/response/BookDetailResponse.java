package com.book.dto.response;

import java.time.LocalDate;

import com.book.entity.Book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class BookDetailResponse {

    private String bookCode;
    private String title;
    private String bookIntroduction;
    private String author;
    private String thumbnailUrl;
    private int stockCount;
    private LocalDate publicationAt;
    private String publisherName;
    private String publisherTelNumber;
    private String categoryName;
    private String bookLocation;

    public static BookDetailResponse of (Book savedBook) {
        return new BookDetailResponse(
            savedBook.getBookCode(),
            savedBook.getTitle(),
            savedBook.getBookIntroduction(),
            savedBook.getAuthor(),
            savedBook.getThumbnail(),
            savedBook.getStockCount(),
            savedBook.getPublicationAt(),
            savedBook.getPublisher().getName(),
            savedBook.getPublisher().getTelNumber(),
            savedBook.getCategory().getCategoryName(),
            savedBook.getBookLocation().getLocationInfo()
        );
    }
}