package com.training.entities;

public class Booking {

	private long code;
	private String user;
	private long bookingNumber;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(long code, String user, long bookingNumber) {
		super();
		this.code = code;
		this.user = user;
		this.bookingNumber = bookingNumber;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public long getBookingNumber() {
		return bookingNumber;
	}
	public void setBookingNumber(long bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
	
	
}
