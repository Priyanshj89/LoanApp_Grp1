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
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ItemService itemService;
	
	@MockBean
	private LoanService loanService;
	
	@MockBean
	private EmployeeService employeeService;
	

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
	public void testLogin() throws Exception {
		String id="123456";
		String password="*****";
		Employee e= new Employee();
		e.setEmployee_id(id);
		e.setPassword(password);
		Mockito.when(employeeService.login(e)).thenReturn("success");
		String json = mapper.writeValueAsString(e);
		mvc.perform(post("/employee/login").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testForgot() throws Exception{
		Employee e = new Employee();		
		e.setEmployee_id("123456");
		e.setName("Vedant");
		e.setPassword("Password@1");
		Mockito.when(employeeService.forgotPass(ArgumentMatchers.any())).thenReturn("Updated");
		String json = mapper.writeValueAsString(e);

		mvc.perform(put("/employee/updatePass").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}