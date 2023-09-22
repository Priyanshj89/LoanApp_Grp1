package com.example.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Item;
import com.example.demo.entities.Loan;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.LoanRepository;

@Service
public class ItemService implements ItemServiceInt {

	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> getAllItems(){
		return itemRepository.findAllEmployeeNull();
	}
	
	public List<Item> getItemsPurchased(EmployeeDto empDto){
		return itemRepository.findAllItemsPurchased(empDto.getEmployee_id());
	}

	public String addItem(ItemDto itemDto) {
		Item item = new Item();
		
		item.setItem_category(itemDto.getItem_category());
		item.setDescription(itemDto.getDescription());
		item.setItem_make(itemDto.getItem_make());
		item.setItem_name(itemDto.getItem_name());
		item.setValuation(itemDto.getValuation());
		item.setIs_applied(itemDto.isIs_applied());
		item.setIs_approved(itemDto.isIs_approved());
		if(itemDto.getEmployee_id()!=null) {
		Employee emp=new Employee();
		emp.setEmployee_id(itemDto.getEmployee_id());
		item.setEmployee(emp);
		}
//		Boolean ifExists = itemRepository.existsById(itemDto.getItem_id());
//		if (!ifExists) {
		itemRepository.save(item);
		return "item Created";
//		} else {
//			return "Item Exists";
//		}

	}
	

	public String deleteItem(Long id) {
		boolean ifExists=itemRepository.existsById(id);
		if(ifExists) {
			itemRepository.deleteById(id);
			return "Deleted from db";
		}
		
		return "error";
	}
	
}
