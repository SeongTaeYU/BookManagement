package com.book.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.request.BookSaveRequest;
import com.book.service.ApiBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/books")
@RequiredArgsConstructor
@RestController
public class ApiBookController {
	
	private final ApiBookService bookService;
	
	@PostMapping("")
	public ResponseEntity<Void> saveNewBook (
		@RequestBody @Valid BookSaveRequest bookSaveRequest){
		
		log.info("Book Save Request >> {}", bookSaveRequest);
		bookService.saveNewBook(bookSaveRequest);
		return ResponseEntity.created(URI.create("/api/books")).build();
	}//end saveNewBook
	
}//end Class Controller
