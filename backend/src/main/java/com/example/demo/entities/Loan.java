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
		
//	@ManyToOne //Works
//	@JoinColumn(name = "employee_id", referencedColumnName="employee_id")
//	private Employee emp;
	
//	@Column(name="employee_id") //FK
//	private String employee_id;
	
	@OneToMany(mappedBy="loan_id") // onetomany
//	@JoinColumn(name = "item_id", referencedColumnName="item_id")
//	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Set<Item> item;
	
//	@Column(name="item_id") //FK
//	private String item_id;
	
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
