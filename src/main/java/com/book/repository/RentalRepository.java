package com.book.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.entity.Rental;
import com.book.enumclass.status.RentalStatus;

public interface RentalRepository extends JpaRepository<Rental, Long>{
	
	  @Query (
		        "select r "
		        + "from Rental r "
		        + "where r.startAt >=:startedAt and r.expiredAt <=:expiredAt and r.onRental=true")
		    List<Rental> findAllByStartAtAndExpiredAtAndOnRental( LocalDate startedAt, LocalDate expiredAt );

		    List<Rental> findRentalByUserEmail ( String email );

		    @Query ("select r from Rental r where r.id =:id and r.onRental = true")
		    Optional<Rental> findById ( Long rentalId );

		    @Query ("select r from Rental r where r.rentalStatus =:rentalStatus ")
		    List<Rental> findAllNonRentals ( RentalStatus rentalStatus );
	
}
