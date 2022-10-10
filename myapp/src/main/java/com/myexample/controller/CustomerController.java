package com.myexample.controller;


import com.myexample.dto.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public List<Customer> retrieveAllCustomers() {

        return Collections.singletonList(Customer.builder().build());

    }



}