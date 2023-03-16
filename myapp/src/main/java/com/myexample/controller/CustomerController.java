package com.myexample.controller;


import com.myexample.dao.CustomerService;
import com.myexample.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "/customers")
    public List<CustomerDto> retrieveAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Optional<CustomerDto> getCustomer(@PathVariable UUID id) {

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