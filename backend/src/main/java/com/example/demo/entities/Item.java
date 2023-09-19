package com.example.demo.entities;
import java.util.ArrayList;

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

	public Item(String item_id, String description, String status, String item_make, String category, int valuation) {
		super();
		this.item_id = item_id;
		this.desc= description;
//		this.status = status;
		this.item_make = item_make;
		this.category = category;
		this.valuation = valuation;
	}

	public Item() {
		super();
	}

}
