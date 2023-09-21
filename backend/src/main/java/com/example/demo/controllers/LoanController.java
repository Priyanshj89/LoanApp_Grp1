package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LoanService;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:3000")
public class LoanController {
	
	@Autowired
	private LoanService loanServ;
	
	
	@GetMapping("/allLoans")
	public List<Loan> allLoan(){
		return loanServ.getAllLoan();
	}
	
	@PostMapping("/addLoan")
	public Loan addLoan(@RequestBody Loan loan) {
		//System.out.println(loan.getItem_id());
		return loanServ.addLoan(loan);
	}
	
	@PostMapping("/getOneLoan")
	public List<?> getOneLoan(@RequestBody String empid) {
		//System.out.println(loan.getItem_id());
		return loanServ.getOneLoan(empid);
	}
}
