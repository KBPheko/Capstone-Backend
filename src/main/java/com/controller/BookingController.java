package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Booking;
import com.service.BookingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	
	@GetMapping("allbookings")
	public ResponseEntity<List<Booking>> viewAllBookings(){
		return ResponseEntity.ok(bookingService.viewAllBookings());
	}
	
	@PostMapping("bookmovie")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking b, @RequestParam Integer mid){
		//return ResponseEntity.ok(bookingService.addBooking(b, mid));
		
		b = bookingService.addBooking(b, mid);
		System.out.println("Booked movie successfully");
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}
	
	@GetMapping("/viewbooking/{bookingid}")
	public ResponseEntity<Booking> viewBooking(@PathVariable int bookingid){
		
		ResponseEntity<Booking> res = null;
		try {
			Booking booking = bookingService.viewBooking(bookingid);
			res= new ResponseEntity<>(booking, HttpStatus.OK);
		} catch (Exception e) {
			res= new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		return res;
	}
	
//	@GetMapping("/search/{keyword}")
//	public ResponseEntity<?> searchByKeyword(@PathVariable ){
//		
//	}
//	
	@GetMapping("/cost/{bookingid}")
	public float totalCostPrice(@PathVariable int bookingid) {
		return bookingService.calculateTotal(bookingid);
	}
}
