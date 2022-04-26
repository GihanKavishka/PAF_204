package com.paf.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "lastReading")
	private long lastReading;

	@Column(name = "presentReading")
	private long presentReading;
	
	@Column(name = "units")
	private long units;
	
	@Column(name = "amount")
	private long amount;
	
	
	
	public Bill() {
		
	}



	public Bill(long id, long lastReading, long presentReading, long units, long amount) {
		super();
		this.id = id;
		this.lastReading = lastReading;
		this.presentReading = presentReading;
		this.units = units;
		this.amount = amount;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getLastReading() {
		return lastReading;
	}



	public void setLastReading(long lastReading) {
		this.lastReading = lastReading;
	}



	public long getPresentReading() {
		return presentReading;
	}



	public void setPresentReading(long presentReading) {
		this.presentReading = presentReading;
	}



	public long getUnits() {
		return units;
	}



	public void setUnits(long units) {
		this.units = units;
	}



	public long getAmount() {
		return amount;
	}



	public void setAmount(long amount) {
		this.amount = amount;
	}



	
	
	
}
