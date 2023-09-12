package com.book.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.book.entity.Book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class BookStockCountResponse {

    private Long bookId;
    private String title;
    private String publisherName;
    private int stockCount;

    public static BookStockCountResponse of (Book book) {
        return BookStockCountResponse.builder()
            .bookId(book.getBookId())
            .title(book.getTitle())
            .publisherName(book.getPublisher().getName())
            .stockCount(book.getStockCount())
            .build();
    }

    public static List<BookStockCountResponse> listOf ( List<Book> books ) {
        List<BookStockCountResponse> stockCountResponses = new ArrayList<>();
        for ( Book book : books ) {
            stockCountResponses.add(of(book));
        }
        return stockCountResponses;
    }
}