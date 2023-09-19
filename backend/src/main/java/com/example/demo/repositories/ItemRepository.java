package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Item;
import com.example.demo.entities.Loan;

@Repository
public interface ItemRepository extends JpaRepository<Item,String>{
//	@Query(value = "SELECT * from item join loan on item.loan_id = loan.loan_id where employee_id = id")
	@Query(value = "SELECT loan.loan_id, loan.issue_date, loan.return_date, loan.loan_type, loan.duration, item.is_approved from item join loan on item.loan_id = loan.loan_id", nativeQuery=true)
	public List<?> findByEmployee_id(String id);

}
