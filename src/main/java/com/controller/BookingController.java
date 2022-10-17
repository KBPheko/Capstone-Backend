package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
//	@PostMapping(value = "book", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String storeMovie(@RequestBody Booking bk) {
//		return bookingService.addBooking(bk);
//	}
	
	public ResponseEntity<Booking> addBooking(@RequestBody Booking b,@RequestParam Integer emailid,@RequestParam Integer movieid){
		return ResponseEntity.ok(bookingService.addBooking(b, emailid, movieid));
	}
}
