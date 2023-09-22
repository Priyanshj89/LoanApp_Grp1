package com.example.demo.dto;

public class ItemDto {
	
	private int item_id; 
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItem_make() {
		return item_make;
	}

	public void setItem_make(String item_make) {
		this.item_make = item_make;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public int getValuation() {
		return valuation;
	}

	public void setValuation(int valuation) {
		this.valuation = valuation;
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

	public String getIssue_status() {
		return issue_status;
	}

	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}

	

	private String item_name;

	private String description;

	private String item_make;

	private String item_category;

	private int valuation;
	
	private boolean is_applied;
	
	private boolean is_approved;

	private String issue_status;
	
	private String loan_id;
	
	private String employee_id;

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}
}
