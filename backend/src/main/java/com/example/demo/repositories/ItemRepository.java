package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Item;
import com.example.demo.entities.Loan;

@Repository
public interface ItemRepository extends JpaRepository<Item,String>{
	
	@Query(value = "SELECT * FROM item WHERE employee_id IS NULL", nativeQuery= true)
	List<Item> findAllEmployeeNull();
	
	@Query(value = "SELECT * FROM item WHERE employee_id = :eid ", nativeQuery=true)
	public List<Item> findAllItemsPurchased(@Param("eid") String employee_id);

}
