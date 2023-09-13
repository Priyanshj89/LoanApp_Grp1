package com.example.demo.service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Employee;

public interface AdminServiceInt {
  Admin addAdmin(Admin admin);
  String login(Admin admin);
  String forgotPass(Admin admin);
  Employee addCustomer(Employee employee);
  
}
