package com.book.entity;


import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.book.dto.request.BookUpdateRequest;
import com.book.enumclass.status.BookStatus;
import com.book.exception.BookStockCountZeroException;
import com.book.exception.NotExistBookStockException;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/13
 */

@ToString (exclude = { "publisher", "bookLocation", "category" })
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NonNull
    @Column (nullable = false, unique = true)
    private String bookCode;

    @NonNull
    @Column (nullable = false)
    private String title;

    @NonNull
    @Column (nullable = false, columnDefinition = "TEXT")
    private String bookIntroduction;

    @NonNull
    @Column (nullable = false)
    private String author;

    @NonNull
    @Column (nullable = false)
    private String thumbnail;

    @Column (nullable = false)
    private int stockCount;

    @Column (nullable = false)
    private int totalRentalCount;

    @NonNull
    @Column (nullable = false)
    @Enumerated (value = EnumType.STRING)
    private BookStatus bookStatus;

    @NonNull
    @Column (nullable = false)
    private LocalDate publicationAt;      // 초판 발행일


    @JoinColumn (name = "publisher_id")
    @ManyToOne (fetch = FetchType.LAZY)
    private Publisher publisher;

    @OneToOne (
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    private BookLocation bookLocation;


    @JoinColumn (name = "category_id")
    @ManyToOne (fetch = FetchType.LAZY)
    private Category category;

    @Builder
    public Book ( Long bookId, @NonNull String bookCode, @NonNull String title,
        @NonNull String bookIntroduction, @NonNull String author,
        @NonNull String thumbnail, @NonNull LocalDate publicationAt, Publisher publisher,
        BookLocation bookLocation, Category category ) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.title = title;
        this.bookIntroduction = bookIntroduction;
        this.author = author;
        this.thumbnail = thumbnail;
        this.stockCount = 5;
        this.totalRentalCount = 0;
        this.bookStatus = BookStatus.REGISTER;
        this.publicationAt = publicationAt;
        this.publisher = publisher;
        this.bookLocation = bookLocation;
        this.category = category;
    }

    public Book updateBook ( BookUpdateRequest updateRequest ) {
        this.title = updateRequest.getTitle();
        this.bookIntroduction = updateRequest.getBookIntroduction();
        this.thumbnail = updateRequest.getThumbnailUrl();
        return this;
    }

    public int updateStockCount ( int stockCount ) {
        this.stockCount = stockCount;
        return this.stockCount;
    }

    public void increaseTotalRentalCount () {
        this.totalRentalCount += 1;
    }

    public void decreaseStockCount () {
        if (this.stockCount > 0) {
            this.stockCount--;
        } else {
            throw new BookStockCountZeroException();
        }

    }

    public void checkStockCount () {
        if ( this.stockCount < 1 ) {
            throw new NotExistBookStockException(this.bookId, this.stockCount);
        }
    }
}