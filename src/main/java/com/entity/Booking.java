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
private String cust;  //emailid
//private String movie;
private String bookingdate;
private float totalprice;
@OneToOne(mappedBy = "booking")
private Movie movie;

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
public String getCust() {
	return cust;
}
public void setCust(String cust) {
	this.cust = cust;
}
//public String getMovie() {
//	return movie;
//}
//public void setMovie(String movie) {
//	this.movie = movie;
//}
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
@Override
public String toString() {
	return "Booking [bid=" + bid + ", cust=" + cust + ", movie=" + movie + ", bookingdate=" + bookingdate + "]";
}

}
