package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="loan")
public class Loan {
	@Id
	@Column(name="loan_id")
	private String loan_id;
	
	@Column(name="loan_type")
	private String loan_type;
	
	@Column(name="column")
	private int duration;
	
	public String getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Loan(String loan_id, String loan_type, int duration) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
		this.duration = duration;
	}
	public Loan() {
		super();
	}
	

}
