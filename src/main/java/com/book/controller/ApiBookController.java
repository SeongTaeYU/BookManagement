package com.book.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.request.BookSaveRequest;
import com.book.dto.response.BookDetailResponse;
import com.book.service.ApiBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */

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
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDetailResponse> findBookById (@PathVariable Long id) {
		log.info("Book Id: {} ", id);
		return ResponseEntity.ok().body(bookService.findBookDetailById(id));
	}
	
}//end Class Controller
