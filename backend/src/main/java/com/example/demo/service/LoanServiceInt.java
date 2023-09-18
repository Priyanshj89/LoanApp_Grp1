package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Loan;

public interface LoanServiceInt {

	List<Loan> getAllLoan();
	Loan addLoan(Loan loan);

}
