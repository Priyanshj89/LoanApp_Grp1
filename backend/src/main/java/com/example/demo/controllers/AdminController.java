package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;

@RestController
@RequestMapping("/admin")
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
}
