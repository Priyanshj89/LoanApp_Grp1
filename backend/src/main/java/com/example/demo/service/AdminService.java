package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class AdminService implements AdminServiceInt{
	@Autowired
  private AdminRepository adminRepo;
	@Autowired
  private EmployeeRepository empRepo;
  
  public Admin addAdmin(Admin admin) {
	  boolean ifExists =adminRepo.existsById(admin.getAdmin_id());
		// User already exists check
		if (!ifExists)
			return adminRepo.save(admin);
		else
		{
			Admin tempAdmin=adminRepo.findById(admin.getAdmin_id()).get();
			tempAdmin.setPassword("*****");
			return tempAdmin;
		}
  }
  
  public String login(Admin admin) {
	  Admin tempAdmin=adminRepo.getReferenceById(admin.getAdmin_id());
		if(tempAdmin.getPassword().equals(admin.getPassword()))
			return "success";
		else
			return "failure";
  }
  
  public String forgotPass(Admin admin) {
	  Admin tempAdmin=adminRepo.getReferenceById(admin.getAdmin_id());
		if(tempAdmin.getName().equals(admin.getName()))
		{
		tempAdmin.setPassword(admin.getPassword());
		adminRepo.save(tempAdmin);
		return "Updated";
		}
		else {
		return "Validation failed";
		}
  }
  
  public Employee addCustomer(Employee employee) {
	  boolean ifExists=empRepo.existsById(employee.getEmployee_id());
		if(ifExists)
		{
			Employee tempEmp=empRepo.findById(employee.getEmployee_id()).get();
			tempEmp.setPassword("*****");
			return tempEmp;
		}
		else {
			return empRepo.save(employee);
		}
  }
  
  
}
