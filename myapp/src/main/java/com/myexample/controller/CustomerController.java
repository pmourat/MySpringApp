package com.myexample.controller;


import com.myexample.dao.CustomerService;
import com.myexample.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "/customers")
    public List<CustomerDto> retrieveAllCustomers(@RequestParam int page, @RequestParam int size, @RequestParam String sort) {
        return customerService.getCustomers(page, size, sort);
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomer(@PathVariable UUID id) {

        return customerService.getCustomer(id);

    }

    @GetMapping("/customers/name/{name}")
    public List<CustomerDto> retrieveCustomersStartsWithLetter(@PathVariable String name) {
        return customerService.findCustomersStartingWith(name);
    }
    @PostMapping("/customers")
    public void createCustomer(@RequestBody CustomerDto customer) {
        customerService.createCustomer(customer);
    }

    @PutMapping("/customers")
    public void modifyCustomer(@RequestBody CustomerDto customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(UUID id) {

    }


}