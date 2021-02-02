package com.vendormanagement.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="vendors")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Column(columnDefinition="char(9)", unique=true)
	private String icNumber;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String slot;
	@NotNull
	@Column(columnDefinition="double")
	private double payment;
	@NotNull
	@Column(columnDefinition="date")
	private String startDate;
	
	public Vendor() {}

	public Vendor(@NotNull String icNumber, @NotNull String name, @NotNull String email, @NotNull String slot, @NotNull double payment,
			@NotNull String startDate) {
		this.icNumber = icNumber;
		this.name = name;
		this.email = email;
		this.slot = slot;
		this.payment = payment;
		this.startDate = startDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.email = slot;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double Payment) {
		this.payment = payment;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
