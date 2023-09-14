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
                + "where b.bookId =:bookId")
        Optional<Book> findByIdJoinFetch(Long bookId);

        List<Book> findByTitleContaining(String title);

//        List<Book> findAllByCategoryId(Long categoryId);	//Spring Data JPA가 해당 메서드를 올바르게 해석하기 위한 변경
        List<Book> findAllByCategory_CategoryId(Long categoryId);

        Optional<Book> findByBookCode(String bookCode);
    }