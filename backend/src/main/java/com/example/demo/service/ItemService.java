package com.example.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Item;
import com.example.demo.entities.Loan;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.LoanRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	LoanRepository loanRepository;

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	public String addItem(Item item) {
		Boolean ifExists = itemRepository.existsById(item.getItem_id());
		if (!ifExists) {
//			Loan loan = item.getLoan_id();
//			String loan_id = loan.getLoan_id();
			String loan_id = "L101"; // should exist in loan table
			int duration = 11;
			Date today = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(today);
			cal.add(Calendar.MONTH, duration);
			Date dueBy = cal.getTime();
			today = new Date();
			Loan loan = new Loan(loan_id, item.getCategory(), duration, today, dueBy);
			item.setLoan_id(loan);
			itemRepository.save(item);
//			itemRepository.updateLoan_id(loan_id, item_id);
			return "item Created";
		} else {
			return "Item Exists";
		}
	}
}
