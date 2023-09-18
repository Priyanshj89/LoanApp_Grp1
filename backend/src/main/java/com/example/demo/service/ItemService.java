package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Item;
import com.example.demo.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	public String addItem(Item item) {
		Boolean ifExists = itemRepository.existsById(item.getItem_id());
		if (!ifExists) {
			itemRepository.save(item);
			return "item Created";
		} else {
			return "Item Exists";
		}
	}
}
