package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.BookLocation;

public interface BookLocationRepository extends JpaRepository<BookLocation, Long>{

}
