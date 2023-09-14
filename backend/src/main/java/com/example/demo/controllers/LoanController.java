package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Loan;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.LoanRepository;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepo;
	

}
