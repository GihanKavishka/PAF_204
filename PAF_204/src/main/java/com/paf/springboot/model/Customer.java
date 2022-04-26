package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "_number")
	private String accountnumber;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_number")
	private long phonenumber;

	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String accountnumber, String address , long phonenumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountnumber = accountnumber;
		this.address = address;
		this.phonenumber = phonenumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getAccountNumber() {
		return accountnumber;
	}
	public void setAccountNumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	
}
