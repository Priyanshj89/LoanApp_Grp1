package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Item;
import com.example.demo.entities.Loan;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.LoanRepository;

@Service
public class ItemService implements ItemServiceInt {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Item> getAllItems(){
		return itemRepository.findAllEmployeeNull();
	}
	
	public List<Item> getItemsPurchased(EmployeeDto empDto){
		return itemRepository.findAllItemsPurchased(empDto.getEmployee_id());
	}
	
	public String addItemOnLoanApplied( ItemDto itemDto) {
		boolean ifExistsItem = itemRepository.existsById(""+itemDto.getItem_id());
		boolean ifExistsEmployee = employeeRepository.existsById(itemDto.getEmployee_id());
		if(ifExistsEmployee && ifExistsItem) {
			Optional<Item> item = itemRepository.findById("" + itemDto.getItem_id());
			Optional<Employee> employee = employeeRepository.findById(itemDto.getEmployee_id());
			Item newItem = item.get();
			newItem.setEmployee(employee.get());
			newItem.setIs_applied(true);
			newItem = itemRepository.save(newItem);
			return ""+newItem.getItem_id();
		}
		else return "error";
	}
	
	public String addItemOnLoanApproved(ItemDto itemDto) {
		boolean ifExistsItem = itemRepository.existsById(""+itemDto.getItem_id());
		boolean ifExistsLoan = loanRepository.existsById(itemDto.getLoan_id());
		if(ifExistsLoan && ifExistsItem) {
			Item item = itemRepository.findById("" + itemDto.getItem_id()).get();
			Loan loan = loanRepository.findById(itemDto.getLoan_id()).get();
			item.setLoan(loan);
			item.setIs_approved(true);
			itemRepository.save(item);
			return "Loan Approved";
		}
		else return "Error";
		
	}
	
	public String addItem(ItemDto itemDto) {
		Item item = new Item();
		
		item.setItem_category(itemDto.getItem_category());
		item.setDescription(itemDto.getDescription());
		item.setItem_make(itemDto.getItem_make());
		item.setItem_name(itemDto.getItem_name());
		item.setValuation(itemDto.getValuation());
//		Boolean ifExists = itemRepository.existsById(itemDto.getItem_id());
//		if (!ifExists) {
		itemRepository.save(item);
		return "item Created";
//		} else {
//			return "Item Exists";
//		}
	}
	
}
