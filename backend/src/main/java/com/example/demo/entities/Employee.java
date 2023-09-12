package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="employee_id")
	private String employee_id;
	@Column(name="name")
	private String name;
	@Column(name="designation")
	private String designation;
	@Column(name="dept")
	private String dept;
	@Column(name="gender")
	private String gender;
	@Column(name="dob")
	private Date dob;
	@Column(name="doj")
	private Date doj;
	@Column(name="password")
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Employee(String employee_id, String name, String designation, String dept, String gender, Date dob,
			Date doj,String password) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.designation = designation;
		this.dept = dept;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
		this.password=password;
	}
	
	
	public Employee() {
		super();
	}
	

}
