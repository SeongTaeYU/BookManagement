package com.book.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.book.entity.Book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@Getter
public class BookSimpleResponse {

    // 도서 이름, 출판사 이름, 썸네일, 작가
    Long bookId;
    String title;
    String author;
    String publisherName;
    String thumbnailUrl;

    public static BookSimpleResponse of ( Book book ) {
        return new BookSimpleResponse(
            book.getBookId(),
            book.getTitle(),
            book.getAuthor(),
            book.getPublisher().getName(),
            book.getThumbnail());
    }

    public static List<BookSimpleResponse> listOf ( List<Book> books ) {
        List<BookSimpleResponse> bookSimpleResponses = new ArrayList<>();

        for ( Book book : books ) {
            bookSimpleResponses.add(of(book));
        }

        return bookSimpleResponses;
    }
}