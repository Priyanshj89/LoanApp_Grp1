package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDto;
import com.example.demo.entities.Item;
import com.example.demo.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	public String addItem(ItemDto itemDto) {
		Item item = new Item();
		item.setCategory(itemDto.getCategory());
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
