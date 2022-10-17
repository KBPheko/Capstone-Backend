package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Movie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)  //auto-increment
private int mid;
private String movietitle;
private String imageurl;
private float ticketprice;
private int quantity;
private String language;
private String description;
private String genre;
private String showtime;
@OneToOne
private Booking booking;

public Booking getBooking() {
	return booking;
}
public void setBooking(Booking booking) {
	this.booking = booking;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMovietitle() {
	return movietitle;
}
public String getImageurl() {
	return imageurl;
}
public void setImageurl(String imageurl) {
	this.imageurl = imageurl;
}
public void setMovietitle(String movietitle) {
	this.movietitle = movietitle;
}
public float getTicketprice() {
	return ticketprice;
}
public void setTicketprice(float ticketprice) {
	this.ticketprice = ticketprice;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getShowtime() {
	return showtime;
}
public void setShowtime(String showtime) {
	this.showtime = showtime;
}
@Override
public String toString() {
	return "Movie [mid=" + mid + ", movietitle=" + movietitle + ", imageurl=" + imageurl + ", ticketprice="
			+ ticketprice + ", quantity=" + quantity + ", language=" + language + ", description=" + description
			+ ", genre=" + genre + ", showtime=" + showtime + "]";
}

}
