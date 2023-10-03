package com.example.demo;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Item;
import com.example.demo.entities.Loan;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.LoanRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ItemService;
import com.example.demo.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ItemService itemService;
	
	@MockBean
	private LoanService loanService;
	
	@MockBean
	private EmployeeService employeeService;

	@MockBean
	private AdminService admServ;
	@MockBean
	private AdminRepository adminRepository;
	
	@MockBean
	private ItemRepository itemRepository;
	
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@MockBean
	private LoanRepository loanRepository;
	
	
	ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAddEmployee() throws Exception{
		Employee e = new Employee("123456","Vedant","Manager","IT","M",new Date(),new Date(),"*****");
		Mockito.when(admServ.addCustomer(e)).thenReturn(e);
		String json = mapper.writeValueAsString(e);

		mvc.perform(post("/admin/addCustomer").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
	
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testAddLoan() throws Exception{
		Loan l = new Loan();
		l.setLoan_id("L0001");
		l.setDuration(3);
		l.setLoan_type("Furniture");
		Mockito.when(loanService.addLoan(ArgumentMatchers.any())).thenReturn(l);
		String json = mapper.writeValueAsString(l);

		mvc.perform(post("/loan/addLoan").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk()).andExpect(jsonPath("$.loan_id").value("L0001"));//,Matchers.equalTo(l.getLoan_id())));
	}

	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll() throws Exception {
		List<Employee> list = new ArrayList<>();
		Employee e = new Employee();	
		e.setDob(new Date());
		e.setDoj(new Date());
		e.setDept("IT");
		e.setDesignation("Manager");
		e.setEmployee_id("123456");
		e.setName("employee");
		e.setGender("M");
		e.setPassword("Password@1");
		list.add(e);
		Mockito.when(employeeService.getAllEmp()).thenReturn(list);
		
		 mvc.perform(get("/employee/allEmployees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		
	}
	
	@Test
	public void testFindAllLoans() throws Exception {
		List<Loan> list = new ArrayList<>();
		Loan l = new Loan();
		l.setLoan_id("L0001");
		l.setDuration(3);
		l.setLoan_type("Furniture");
		list.add(l);
		Mockito.when(loanService.getAllLoan()).thenReturn(list);
		
		mvc.perform(get("/loan/allLoans").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	@Test
	public void testDeleteEmployee() throws Exception {
		String id = "123456";
		String e = "Deleted from db";
		Mockito.when(employeeService.deleteEmp(id)).thenReturn(e);
		
		MvcResult requestResult= mvc.perform(delete("/employee/delete/{id}",id).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result = requestResult.getResponse().getContentAsString();
		assertEquals(result,e);
	}

	
	@Test
	public void testDeleteItem() throws Exception {
		String id = "1";
		String e = "str";
		Mockito.when(itemService.deleteItem(ArgumentMatchers.any())).thenReturn(e);
		
		MvcResult requestResult = mvc.perform(delete("/item/delete/{id}",id).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result = requestResult.getResponse().getContentAsString();
		assertEquals(result,e);
	}
	
}