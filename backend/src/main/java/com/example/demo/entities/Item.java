package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class Item {

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", description=" + description + ", item_make="
				+ item_make + ", item_category=" + item_category + ", valuation=" + valuation + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private long item_id;
	
	@ManyToOne
	@JoinColumn(name ="loan_id")
	Loan loan;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	Employee employee;

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isIs_applied() {
		return is_applied;
	}

	public void setIs_applied(boolean is_applied) {
		this.is_applied = is_applied;
	}

	public boolean isIs_approved() {
		return is_approved;
	}

	public void setIs_approved(boolean is_approved) {
		this.is_approved = is_approved;
	}

	@Column(name = "item_name")
	private String item_name;

	@Column(name = "description")
	private String description;

	@Column(name = "item_make")
	private String item_make;

	@Column(name = "item_category")
	private String item_category;

	@Column(name = "valuation")
	private int valuation;
	
	@Column(name = "is_applied")
	private boolean is_applied;
	
	@Column(name = "is_approved")
	private boolean is_approved;
	
	@Column(name = "issue_status")
	private String issue_status;
	

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_make() {
		return item_make;
	}

	public void setItem_make(String item_make) {
		this.item_make = item_make;
	}

	public int getValuation() {
		return valuation;
	}

	public void setValuation(int valuation) {
		this.valuation = valuation;
	}

	public Item(long item_id, Loan loan, Employee employee, String item_name, String description, String item_make,
			String item_category, int valuation, boolean is_applied, boolean is_approved, String issue_status) {
		super();
		this.item_id = item_id;
		this.loan = loan;
		this.employee = employee;
		this.item_name = item_name;
		this.description = description;
		this.item_make = item_make;
		this.item_category = item_category;
		this.valuation = valuation;
		this.is_applied = is_applied;
		this.is_approved = is_approved;
		this.issue_status = issue_status;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getIssue_status() {
		return issue_status;
	}

	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}

	public Item() {
		super();
	}

}
