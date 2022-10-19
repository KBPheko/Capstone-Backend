package com.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Booking;
import com.entity.Login;
import com.entity.Movie;
import com.repository.BookingRepository;
import com.repository.LoginRepository;
import com.repository.MovieRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	LoginRepository loginRepository;
	
	//List all bookings
	public List<Booking> showAllBookings(){
		return bookingRepository.findAll();
	}
	
	//get booking by id
	public Booking viewBooking(int bookingid) {
		return bookingRepository.findById(bookingid).get();
	}
	
	public Booking addBooking(Booking booking, Integer movieid) {
		
		Movie mov = new Movie();
		if(movieid!=null) {
			mov = movieRepository.findById(movieid).get(); //fetch the movie to book
			
			booking.setMovie(mov);  //then set it inside booking
		}
		bookingRepository.saveAndFlush(booking);
		
		return booking; //contains movie id
		
	}
	
	public String bookMovie(Booking booking) {
		bookingRepository.save(booking);
		return "Movie booked successfully";
	}
	
	
	public String cancelBooking(int bid) {
		Optional<Booking> result = bookingRepository.findById(bid);
		
		if(result.isPresent()) {
			Booking bk = result.get();
			bookingRepository.delete(bk);
			return "Movie Booking Cancelled : "+bk;
		} else {
			return "Couldn't cancel booking";
		}
	}
	
	public String updateBooking(Booking booking) {
		Optional<Booking> result = bookingRepository.findById(booking.getBid());
		
		if(result.isPresent()) {
			Booking booking1 = result.get();
			booking1.setMovie(booking.getMovie());
			booking1.setBookingdate(booking.getBookingdate());
			
			bookingRepository.saveAndFlush(booking1);
			return "Booking updated successfully";
		} else {
			return "Couldn't find booking, could not update booking";
		}
	}
	
	public float calculateTotal(int bookingid) {
		//List<Booking> tickets = bookingRepository.findAll();
		
		Set<Movie> movies = new HashSet<>();
		
		float amount = 0;
		for (Movie movie : movies) {
			amount = amount + movie.getTicketprice();
		}
		
		Booking booking = bookingRepository.getOne(bookingid);
		booking.setTotalprice(amount);
		bookingRepository.saveAndFlush(booking);
		return amount;
	}
	
	//get all bookings
	public List<Booking> viewAllBookings(){
		List<Booking> bkl = bookingRepository.findAll();
		return bkl;
	}
}
