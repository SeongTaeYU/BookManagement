package com.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
	
	Optional<Publisher> findByBusinessNumber(String businessNumber);
	
}
