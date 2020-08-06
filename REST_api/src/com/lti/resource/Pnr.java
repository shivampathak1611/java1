package com.lti.resource;

import java.time.LocalDate;
import java.util.List;

public class Pnr {

	private int pnrNo;
	private int trainNo;
	private LocalDate travelDate;
	
	private List<Passenger> passengers;

	public Pnr()
	{
		
	}
	
	public Pnr(int pnrNo, int trainNo, LocalDate travelDate, List<Passenger> passengers) {
		super();
		this.pnrNo = pnrNo;
		this.trainNo = trainNo;
		this.travelDate = travelDate;
		this.passengers = passengers;
	}
	public int getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}