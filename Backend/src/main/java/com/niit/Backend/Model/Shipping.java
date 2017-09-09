package com.niit.Backend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Shipping {
	@Id
	private String First_Name;
	private String Last_Name;
	private String Shiping_Id;
	private String House_No;
	private String Country;
	private String City;
	private String PinCode;
	private String Email;
	private String Mobile_No;
	
	@ManyToOne
	@JoinColumn(name="uid")
	private User user;
	public Shipping()
	{
		this.Shiping_Id="SHI"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getShiping_Id() {
		return Shiping_Id;
	}
	public void setShiping_Id(String shiping_Id) {
		Shiping_Id = shiping_Id;
	}
	public String getHouse_No() {
		return House_No;
	}
	public void setHouse_No(String house_No) {
		House_No = house_No;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile_No() {
		return Mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

}
