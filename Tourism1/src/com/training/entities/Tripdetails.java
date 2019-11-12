package com.training.entities;

import java.time.LocalDate;

public class Tripdetails {

	private long tripCode;
	private String tourName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String origin;
	private String destination;
	private double cost;
	public Tripdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tripdetails(long tripCode, String tourName, LocalDate startDate, LocalDate endDate,
			String origin, String destination,double cost) {
		super();
		this.tripCode = tripCode;
		this.cost = cost;
		this.tourName = tourName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.origin = origin;
		this.destination = destination;
	}
	public long getTripCode() {
		return tripCode;
	}
	public void setTripCode(long tripCode) {
		this.tripCode = tripCode;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
}
