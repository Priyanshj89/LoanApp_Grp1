package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,String>{
	
	@Query("SELECT it.item_id FROM item it WHERE employee_id IS NULL")
	List<Item> findAllEmployeeNull();
}
