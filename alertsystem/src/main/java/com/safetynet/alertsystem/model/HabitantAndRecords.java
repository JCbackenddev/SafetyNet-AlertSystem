package com.safetynet.alertsystem.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class HabitantAndRecords {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;
	private String birthdate;
	private Integer age;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	private Integer Id;
	
	public HabitantAndRecords(String firstName, String lastName, String address, String city, String zip, String phone,
			String email, String birthdate, Integer age, ArrayList<String> medications, ArrayList<String> allergies, Integer id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
		Id = id;
	}
	
	public HabitantAndRecords() {
		// empty constructor for the addPersonInfoForm() method
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public ArrayList<String> getMedications() {
		return medications;
	}

	public void setMedications(ArrayList<String> medications) {
		this.medications = medications;
	}

	public ArrayList<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(ArrayList<String> allergies) {
		this.allergies = allergies;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer calculateAge(String birthdate2) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

		//convert String to LocalDate
		LocalDate localBirthDate = LocalDate.parse(birthdate2, formatter);
		LocalDate today = LocalDate.now();
		
		Integer years = (int) ChronoUnit.YEARS.between(localBirthDate, today);
		
		setAge(years);
		
		return years;
	}
}
