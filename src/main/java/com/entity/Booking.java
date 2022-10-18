package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bid;   //booking ID
private int tickets; 
private String bookingdate;
private float totalprice;
@OneToOne(mappedBy = "booking")
private Movie movie;
@ManyToOne
private Login customer;

public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getTickets() {
	return tickets;
}
public void setTickets(int tickets) {
	this.tickets = tickets;
}
public String getBookingdate() {
	return bookingdate;
}
public void setBookingdate(String bookingdate) {
	this.bookingdate = bookingdate;
}
public float getTotalprice() {
	return totalprice;
}
public void setTotalprice(float totalprice) {
	this.totalprice = totalprice;
}
public Login getCustomer() {
	return customer;
}
public void setCustomer(Login customer) {
	this.customer = customer;
}
@Override
public String toString() {
	return "Booking [bid=" + bid + ", tickets=" + tickets + ", bookingdate=" + bookingdate + ", totalprice="
			+ totalprice + ", movie=" + movie + ", customer=" + customer + "]";
}

}
