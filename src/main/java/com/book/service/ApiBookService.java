package com.book.service;

import java.util.Collections;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.book.dto.request.BookSaveRequest;
import com.book.dto.request.BookUpdateRequest;
import com.book.dto.response.BookDetailResponse;
import com.book.dto.response.BookSimpleResponse;
import com.book.dto.response.BookStockCountResponse;
import com.book.entity.Book;
import com.book.entity.BookLocation;
import com.book.entity.Category;
import com.book.entity.Publisher;
import com.book.repository.BookRepository;
import com.book.repository.CategoryRepository;
import com.book.repository.PublisherRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiBookService {
	
	private final BookRepository bookRepository;
	private final CategoryRepository categoryRepository;
	private final PublisherRepository publisherRepository;

	@Transactional
	public Book saveNewBook(BookSaveRequest bookSaveRequest) {
		
		isDuplicatedBook(bookSaveRequest.getBookCode());
		Category category = findCategoryById(bookSaveRequest.getCategoryId());
		Publisher publisher = findPublisherByBusinessNumber(bookSaveRequest.getPublisherBusinessNumber());
		BookLocation bookLocation = createLocation(category, bookSaveRequest.getLocationCode());
		
		return saveNewBook(bookSaveRequest, category, publisher, bookLocation);
	}//end saveNewBook(BookSaveRequest bookSaveRequest)

	@Transactional(readOnly = true)
	public BookDetailResponse findBookDetailById(Long bookId) {
		Book findBook = findBookById(bookId);
		return BookDetailResponse.of(findBook);
	}//end findBookDetailById

	
	@Transactional(readOnly = true)
	public List<BookSimpleResponse> findBooksByTitle(String title){
		List<Book> books = bookRepository.findByTitleContaining(title);
		return Collections.unmodifiableList(BookSimpleResponse.listOf(books));
	}//end findBooksByTitle
	

	@Transactional(readOnly = true)
	public List<BookStockCountResponse> findAllBooksStockCount(Long categoryId){
		findCategoryById(categoryId);
		List<Book> books = bookRepository.findAllByCategoryId(categoryId);
		return Collections.unmodifiableList(BookStockCountResponse.listOf(books));
	}//end findAllBooksStockCount
	
	@Transactional
	public Book updateBookInfo (Long bookId, BookUpdateRequest bookUpdateRequest) {
		Book savedBook = findBookById(bookId);
		return savedBook.updateBook(bookUpdateRequest);
	}//end updateBookInfo
	
	@Transactional
	public Integer stockCountUpdate(Long id, Integer stockCount) {
		Book book = findBookById(id);
		return book.updateStockCount(stockCount);
	}//end stockCountUpdate

	
	private Book saveNewBook(BookSaveRequest bookSaveRequest, Category category, Publisher publisher,
			BookLocation bookLocation) {
		
		Book newBook = bookSaveRequest.createNewBook(category, publisher, bookLocation);
		
		return bookRepository.save(newBook);
	}//end saveNewBook

	private BookLocation createLocation(Category category, String locationCode) {
		return BookLocation.builder()
				.categoryName(category.getCategoryName())
				.locationCode(locationCode)
				.build();
	}//end createLocation
	
	private Book findBookById(Long bookId) {
		return bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException(bookId));
	}//end findBookById
	
	private void isDuplicatedBook(String bookCode) {
		
		if(bookRepository.findByBookCode(bookCode).isPresent()) {
			throw new AlreadyExistBookException(bookCode);
		}
	}//end isDuplicatedBook
	
	private Category findCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId)
			.orElseThrow(()-> new CategoryNotFoundException(categoryId)) ;
	}//end findCategoryById
	
	private Publisher findPublisherByBusinessNumber(String publisherBusinessNumber) {
		return publisherRepository.findByBusinessNumber(publisherBusinessNumber)
				.orElseThrow(() -> new BusinessNumberNotFoundException(publisherBusinessNumber));
	}//end findPublisherByBusinessNumber
	
}//end Class ApiBookService
