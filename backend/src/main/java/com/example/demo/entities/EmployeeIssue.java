package com.example.demo.entities;

import java.util.Date;

public class EmployeeIssue {
	private String issue_id;
	private String employee_id;
	private String item_id;
	private Date issue_date;
	private Date return_date;
	public EmployeeIssue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeIssue(String issue_id, String employee_id, String item_id, Date issue_date, Date return_date) {
		super();
		this.issue_id = issue_id;
		this.employee_id = employee_id;
		this.item_id = item_id;
		this.issue_date = issue_date;
		this.return_date = return_date;
	}
	public String getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
}
