package com.example.demo.controllers;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.ItemDto;
import com.example.demo.entities.Item;
import com.example.demo.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/item")
@CrossOrigin("http://localhost:3000")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/allItems")
	List<Item> allItems(){
		return itemService.getAllItems();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteItem(@PathVariable String id) {
		return itemService.deleteItem(id);
	}
	
	@PostMapping("/getItemsPurchased")
	List<Item> getItemsPurchased(@RequestBody EmployeeDto employeeDto) {
		return itemService.getItemsPurchased(employeeDto);
	}
	
	@PostMapping("/addItem")
	ResponseEntity<String> addItem(@RequestBody ItemDto item){

		return new ResponseEntity<>(itemService.addItem(item), HttpStatus.OK);
	}
	
	@PostMapping("/applyLoan")
	ResponseEntity<String> applyLoan(@RequestBody ItemDto item){

		return new ResponseEntity<>(itemService.addItemOnLoanApplied(item), HttpStatus.OK);
	}
	
	@GetMapping("/getToBeapproved")
	public List<Item> listItemstobeApproved(){
		return itemService.getItemsApp();
	}
	@PostMapping("/addItemOnLoanApproved")
	ResponseEntity<String> addItemOnLoanApproved(@RequestBody ItemDto itemDto){
		return new ResponseEntity<>(itemService.addItemOnLoanApproved(itemDto),HttpStatus.OK);
	}
	
}
