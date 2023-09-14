package com.book.service;

import com.book.dto.request.RentalRequest;
import com.book.dto.response.NonReturnBooks;
import com.book.dto.response.RentalSimpleResponse;
import com.book.enumclass.status.RentalStatus;
import com.book.exception.BookNotFoundException;
import com.book.exception.NotExistEmailException;
import com.book.exception.RentalNotFoundException;
import com.book.exception.UserNotFoundException;
import com.book.entity.Book;
import com.book.entity.Rental;
import com.book.entity.User;
import com.book.repository.BookRepository;
import com.book.repository.RentalRepository;
import com.book.repository.UserRepository;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiRentalService {

    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Transactional
    public Rental registRental ( RentalRequest rentalRequest ) {
        log.info("Rental Request: {} ", rentalRequest);
        Book savedBook = findBookById(rentalRequest.getBookId());
        savedBook.checkStockCount();
        savedBook.increaseTotalRentalCount();
        savedBook.decreaseStockCount();

        User savedUser = findUserById(rentalRequest.getUserId());
        savedUser.increaseBookRentalCount();

        return rentalRepository.save(Rental.of(savedBook, savedUser));
    }

    @Transactional (readOnly = true)
    public List<RentalSimpleResponse> findRentalOnWeek ( LocalDate startedAt, LocalDate expiredAt ) {
        return Collections.unmodifiableList(RentalSimpleResponse
            .listOf(rentalRepository.findAllByStartAtAndExpiredAtAndOnRental(startedAt, expiredAt)));
    }

    @Transactional (readOnly = true)
    public List<RentalSimpleResponse> findRentalsByUserEmail (String email) {
        findUserByEmail(email);
        return Collections.unmodifiableList(RentalSimpleResponse
            .listOf(rentalRepository.findRentalByUserEmail(email)));
    }

    @Transactional (readOnly = true)
    public List<NonReturnBooks> findAllNonReturnBook () {

        return Collections.unmodifiableList(NonReturnBooks
            .listOf(rentalRepository.findAllNonRentals(RentalStatus.NON_RETURN)));
    }

    @Transactional
    public Rental expandRentalPeriod ( Long rentalId ) {
        Rental rental = findRentalById(rentalId);
        rental.returnPeriodExtend();
        return rental;
    }

    @Transactional
    public Rental returnRentalBook ( Long rentalId ) {
        Rental rental = findRentalById(rentalId);
        rental.returnRentalBook();
        return rental;
    }

    private Book findBookById ( Long bookId ) {
        return bookRepository.findById(bookId)
            .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    private Rental findRentalById ( Long rentalId ) {
        return rentalRepository.findById(rentalId)
            .orElseThrow(() -> new RentalNotFoundException(rentalId));
    }

    private User findUserById ( Long userId ) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));
    }

    private User findUserByEmail ( String email ) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new NotExistEmailException(email));
    }

}
