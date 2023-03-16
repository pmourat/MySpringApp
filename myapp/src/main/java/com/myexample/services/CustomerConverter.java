package com.myexample.services;

import com.myexample.dto.CustomerDto;
import com.myexample.entities.Customer;
import org.springframework.core.convert.converter.Converter;

public class CustomerConverter implements Converter<CustomerDto, Customer> {

    @Override
    public Customer convert(CustomerDto customerDto) {
        return new Customer(customerDto.getId(),customerDto.getFirstName(), customerDto.getSurname(), customerDto.getAddress(), customerDto.getEmail());
    }

}
