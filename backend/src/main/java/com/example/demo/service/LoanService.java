package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Loan;
import com.example.demo.repositories.LoanRepository;

@Service
public class LoanService implements LoanServiceInt {
	
	@Autowired
	private LoanRepository loanRepo;
	
	public List<Loan> getAllLoan(){
		return loanRepo.findAll();
	}
	
	public Loan addLoan(Loan loan) {
		  boolean ifExists=loanRepo.existsById(loan.getLoan_id());
			if(ifExists)
			{
				Loan tempLoan = loanRepo.findById(loan.getLoan_id()).get();
				return tempLoan;
			}
			else {
				return loanRepo.save(loan);
			}
	  }

}
