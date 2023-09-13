package com.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query (value =
            "select distinct b "
                + "from Book b "
                + "join fetch b.category "
                + "join fetch b.publisher "
                + "join fetch b.bookLocation "
                + "where b.id =:id")
        Optional<Book> findByIdJoinFetch(Long bookId);

        List<Book> findByTitleContaining(String title);

        List<Book> findAllByCategoryId(Long BookId);

        Optional<Book> findByBookCode(String bookCode);
    }