package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
    private AdminRepository adminRepo;
	
	@GetMapping("/add")
	public String addHello() {
		return "Hello";
	}
	
	@PostMapping("/adduser")
	public Admin addAddmin(@RequestBody Admin admin) {
		return adminRepo.save(admin);
	}
	
	@PostMapping("/login")
	public String validateLogin(@RequestBody Admin admin) {
		Admin tempAdmin=adminRepo.getReferenceById(admin.getAdmin_id());
		if(tempAdmin.getPassword().equals(admin.getPassword()))
			return "success";
		else
			return "failure";
	}
	
	@PutMapping("/updatePass")
	public String forgotPassword(@RequestBody Admin admin)
	{
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
}
