package com.example.demo.service;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.ItemDto;
import com.example.demo.entities.Item;

public interface ItemServiceInt {
	
	public List<Item> getAllItems();
	
	public String addItem(ItemDto itemDto);
}
