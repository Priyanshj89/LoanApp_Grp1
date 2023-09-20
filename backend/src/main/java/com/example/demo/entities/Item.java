package com.example.demo.entities;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	// loan id, userid, IsApplied boolean, isApproved
	@ManyToOne
	@JoinColumn(name = "loan_id", referencedColumnName="loan_id")
	private Loan loan_id;
	
	public Item(Loan loan_id, Employee emp_id, String item_id, boolean is_applied, boolean isApproved, String desc,
			String status, String item_make, String category, int valuation) {
		super();
		this.loan_id = loan_id;
		this.emp_id = emp_id;
		this.item_id = item_id;
		this.is_applied = is_applied;
		this.isApproved = isApproved;
		this.desc = desc;
		this.status = status;
		this.item_make = item_make;
		this.category = category;
		this.valuation = valuation;
	}
	public Loan getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(Loan loan_id) {
		this.loan_id = loan_id;
	}
	public Employee getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Employee emp_id) {
		this.emp_id = emp_id;
	}
	public boolean isIs_applied() {
		return is_applied;
	}
	public void setIs_applied(boolean is_applied) {
		this.is_applied = is_applied;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName="employee_id")
	private Employee emp_id;
	
	@Id
	@Column(name="item_id")
	private String item_id;
	
	@Column(name="is_applied")
	private boolean is_applied;
	
	@Column(name="is_approved")
	private boolean isApproved;
	
	@Column(name="description")
	private String desc;
	
	@Column(name="status")
	private String status;
	
	@Column(name="item_make")
	private String item_make;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name="item_category")
	private String category;
	
	@Column(name="valuation")
	private int valuation;

	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getDesc() {
		return desc;
	}

	public void setDescription(String desc) {
		this.desc= desc;
	}

//	public String getItem_name() {
//		return item_name;
//	}

//	public void setItem_name(String item_name) {
//		this.item_name = item_name;
//	}

	public String getItem_make() {
		return item_make;
	}

	public void setItem_make(String item_make) {
		this.item_make = item_make;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getValuation() {
		return valuation;
	}

	public void setValuation(int valuation) {
		this.valuation = valuation;
	}

	public Item() {
		super();
	}

}
