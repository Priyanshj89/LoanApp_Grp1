package com.example.demo.service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Employee;
import com.example.demo.exceptions.RecordAlreadyExistsException;

public interface AdminServiceInt {
  Admin addAdmin(Admin admin) throws RecordAlreadyExistsException;
  String login(Admin admin);
  String forgotPass(Admin admin);
  Employee addCustomer(Employee employee) throws RecordAlreadyExistsException;
  
}
