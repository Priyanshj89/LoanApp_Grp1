package com.example.demo.controllers;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Item;
import com.example.demo.service.ItemService;

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
	
	@PostMapping("/addItem")
	ResponseEntity<String> addItem(@RequestBody Item item){
		return new ResponseEntity<>(itemService.addItem(item), HttpStatus.OK);
	}
	
}