package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Booking {
@Id
private int bid;   //booking ID
@ManyToOne
private Login cust;
@OneToOne
private Movie movie;
private String bookingdate;
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public Login getCust() {
	return cust;
}
public void setCust(Login cust) {
	this.cust = cust;
}
public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
public String getBookingdate() {
	return bookingdate;
}
public void setBookingdate(String bookingdate) {
	this.bookingdate = bookingdate;
}
@Override
public String toString() {
	return "Booking [bid=" + bid + ", cust=" + cust + ", movie=" + movie + ", bookingdate=" + bookingdate + "]";
}

}
