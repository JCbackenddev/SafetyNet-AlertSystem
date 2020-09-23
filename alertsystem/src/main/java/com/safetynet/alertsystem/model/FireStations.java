package com.safetynet.alertsystem.model;

public class FireStations {
	
	private String address;
	private Integer station;
	private int id;
	
	public FireStations(String address, int station, int id) {
		super();
		this.address = address;
		this.station = station;
		this.id = id;
	}
	
	public FireStations() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
