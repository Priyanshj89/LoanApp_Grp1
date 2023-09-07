package com.example.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service

public class TestService {
    public String GetText(){
        return "Hello World";
    }
}
