package com.example.demo.entities;

import java.util.Date;

public class Employee {
	private String employee_id;
	private String name;
	private String designation;
	private String dept;
	private String gender;
	private Date dob;
	private Date doj;
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Employee(String employee_id, String name, String designation, String dept, String gender, Date dob,
			Date doj) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.designation = designation;
		this.dept = dept;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
	}
	
	public Employee() {
		super();
	}
	

}
