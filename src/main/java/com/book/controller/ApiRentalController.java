package com.book.controller;

import com.book.dto.request.RentalRequest;
import com.book.dto.response.NonReturnBooks;
import com.book.dto.response.RentalSimpleResponse;
import com.book.service.ApiRentalService;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CreateBy: SeongTae
 * @Date: 2023/09/14
 */

@Slf4j
@RequestMapping ("/api/rental")
@RequiredArgsConstructor
@RestController
public class ApiRentalController {

    private final ApiRentalService rentalService;

    @PostMapping ("")
    public ResponseEntity<Void> registRental ( @RequestBody RentalRequest rentalRequest ) {
        log.info("rental request: {}", rentalRequest);
        rentalService.registRental(rentalRequest);
        return ResponseEntity.created(URI.create("/api/rental")).build();
    }

    @GetMapping ("")
    public ResponseEntity<List<RentalSimpleResponse>> findRentalsOnWeek (
        @RequestParam (value = "startedAt", required = true) @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate startedAt,
        @RequestParam (value = "expiredAt", required = true) @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate expiredAt ) {

        return ResponseEntity.ok().body(rentalService.findRentalOnWeek(startedAt, expiredAt));
    }

    @GetMapping("/user")
    public ResponseEntity<List<RentalSimpleResponse>> findAllRentalOfUser (@RequestParam(value = "email", required = true) String email) {
       return ResponseEntity.ok().body(rentalService.findRentalsByUserEmail(email));
    }

    @GetMapping("/non")
    public ResponseEntity<List<NonReturnBooks>> findAllNonReturnBook () {
        return ResponseEntity.ok().body(rentalService.findAllNonReturnBook());
    }

    @PatchMapping("/{realId}")
    public ResponseEntity<Void> expendRentalPeriod (@PathVariable(name = "realId") Long rentalId ) {
        rentalService.expandRentalPeriod(rentalId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{realId}")
    public ResponseEntity<Void> returnRentalBook (@PathVariable(name = "realId") Long rentalId) {
        rentalService.returnRentalBook(rentalId);
        return ResponseEntity.ok().build();
    }
}
