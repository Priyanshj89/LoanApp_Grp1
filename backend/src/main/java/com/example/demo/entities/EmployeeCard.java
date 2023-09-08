package com.example.demo.entities;

import java.util.Date;

public class EmployeeCard {
	private String employee_id;
	private String loan_id;
	private Date issue_date;
	public EmployeeCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeCard(String employee_id, String loan_id, Date issue_date) {
		super();
		this.employee_id = employee_id;
		this.loan_id = loan_id;
		this.issue_date = issue_date;
	}
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
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
}
