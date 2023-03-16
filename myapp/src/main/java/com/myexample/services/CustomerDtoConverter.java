package com.myexample.services;

import com.myexample.dto.CustomerDto;
import com.myexample.entities.Customer;
import org.springframework.core.convert.converter.Converter;

public class CustomerDtoConverter implements Converter<Customer, CustomerDto> {

    @Override
    public CustomerDto convert(Customer customer) {
        return new CustomerDto(customer.getId(),customer.getFirstName(), customer.getSurname(), customer.getAddress(), customer.getEmail());
    }

}
