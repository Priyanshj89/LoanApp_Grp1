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
//	@Query(value = "SELECT * from item join loan on item.loan_id = loan.loan_id where employee_id = id")
	@Query(value = "SELECT loan.loan_id, loan.issue_date, loan.return_date, loan.loan_type, loan.duration, item.is_approved from item join loan on item.loan_id = loan.loan_id", nativeQuery=true)
	public List<?> findByEmployee_id(String id);
//	
//	@Query(value = "UPDATE item e set e.loan_id as :lid where e.item_id = :iid;", nativeQuery=true)
//	public String updateLoan_id(@Param("lid") String loan_id, @Param("iid") String item_id);

}
//"item_id": 91,
//"description":"demo",
//"issue_status": "Y",
//"item_make": "woodden",
//"item_category": "elctronic",
//"valuation": 100,
//"is_approved": true,
//"is_applied": false,
//"status": "applied",
//"loan_id": "L901",
//"employee_id":1