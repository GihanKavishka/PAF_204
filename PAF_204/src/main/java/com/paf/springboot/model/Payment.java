package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "card_number")
	private String card_number;
	
	@Column(name = "Pay_date")
	private String Pay_date;
	
	@Column(name = "Acc_no")
	private String Acc_no;
	
	public Payment(){
		
	}

	public Payment(long id, String name, String email,String amount, String card_number, String Pay_date, String Acc_no) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.amount = amount;
		this.card_number = card_number;
		this.Pay_date = Pay_date;
		this.Acc_no = Acc_no;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getPay_date() {
		return Pay_date;
	}

	public void setPay_date(String Pay_date) {
		this.Pay_date = Pay_date;
	}

	public String getAcc_no() {
		return Acc_no;
	}

	public void setAcc_no(String Acc_no) {
		this.Acc_no = Acc_no;
	}
	
	

	
}

