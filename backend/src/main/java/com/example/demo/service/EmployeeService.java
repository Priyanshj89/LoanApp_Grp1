package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInt {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	public List<Employee> getAllEmp(){
		return empRepo.findAll();
	}
	
	public Employee getOneEmp(String id){
		Employee tempEmp= empRepo.findById(id).get();
		return tempEmp;
	}
	
	public String deleteEmp(String id) {
		boolean ifExists=empRepo.existsById(id);
		if(ifExists) {
			empRepo.deleteById(id);
			return "Deleted from db";
		}
		
		return "error";
	}
	public String updateEmployee(Employee emp) {
		boolean ifExists=empRepo.existsById(emp.getEmployee_id());
		if(ifExists) {
			Employee tempEmp=empRepo.findById(emp.getEmployee_id()).get();
			tempEmp.setDept(emp.getDept());
			tempEmp.setDesignation(emp.getDesignation());
			tempEmp.setDob(emp.getDob());
			tempEmp.setDoj(emp.getDoj());
			tempEmp.setGender(emp.getGender());
			tempEmp.setName(emp.getName());
			empRepo.save(tempEmp);
			return "updated";
		}
		else
		return "error";
	}
	
	public String login(Employee emp) {
		try {
			Employee tempEmp=empRepo.getReferenceById(emp.getEmployee_id());
			if(tempEmp.getPassword().equals(emp.getPassword()))
				return "success";
			else
				return "failure";
		}
		catch (jakarta.persistence.EntityNotFoundException e) 
		{
			return "User Does not Exist";
		}
	}
	
	public String forgotPass(Employee emp) {
		try {
			Employee tempEmp=empRepo.getReferenceById(emp.getEmployee_id());
			if(tempEmp.getName().equals(emp.getName()))
			{
			tempEmp.setPassword(emp.getPassword());
			empRepo.save(tempEmp);
			return "Updated";
			}
			else {
			return "Validation failed";
			}
			}
			catch (jakarta.persistence.EntityNotFoundException e) 
			{
				return "User Does not Exist";
			}
	}

}
