package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="loan")
public class Loan {
	@Id
	@Column(name="loan_id")
	private String loan_id;
		

	
	@OneToMany(mappedBy="loan_id") 

	private Set<Item> item;
	

	@Column(name="issue_date")
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date issue_date;
	
	@Column(name="return_date")
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date return_date;
	
	@Column(name="loan_type")
	private String loan_type;
	
	@Column(name="duration")
	private int duration;
	
	
	
	
	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

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
	public void setIssue_date(Date issue_date) {
		this.issue_date=issue_date;
	}
	
	public Date getIssue_date() {
		return issue_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	
	public void setReturn_date(Date return_date) {
		this.return_date=return_date;
	}
	
	
	
	public Loan(String loan_id, String loan_type, int duration,Date issue_date, Date return_date) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
		this.duration = duration;
		this.issue_date=issue_date;
		this.return_date=return_date;
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