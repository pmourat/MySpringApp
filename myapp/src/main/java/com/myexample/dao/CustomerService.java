package com.myexample.dao;

import com.myexample.dto.CustomerDto;
import com.myexample.entities.Customer;
import com.myexample.repository.CustomerRepository;
import com.myexample.repository.Specifications.CustomerSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ConversionService conversionService;

    public CustomerDto getCustomer(UUID customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.isPresent() ? conversionService.convert(optionalCustomer.get(), CustomerDto.class) : CustomerDto.builder().build();
    }

    public List<CustomerDto> getCustomers(Integer pageNumber, Integer pageSize, String sort) {

        Sort sortBy = Sort.by(sort).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortBy);

        Page<Customer> entityPage = customerRepository.findAll(pageable);
        return entityPage.get().map(c -> conversionService.convert(c, CustomerDto.class)).collect(Collectors.toList());


    }

    public void createCustomer(CustomerDto customerDto) {
        Customer customer = conversionService.convert(customerDto, Customer.class);
        customerRepository.save(customer);
    }

    public void updateCustomer(CustomerDto customerDto) {
        //Todo Mayby create my custom exception
        Customer customer = customerRepository.findById(customerDto.getId()).orElseThrow();

        customer.setFirstName(customerDto.getFirstName());
        customer.setSurname(customerDto.getSurname());
        customer.setEmail(customerDto.getEmail());
        customer.setAddress(customerDto.getAddress());

        customerRepository.save(customer);
    }

    public List<CustomerDto> findCustomersStartingWith(String str) {
        List<Customer> customers = customerRepository.findAll(CustomerSpecifications.nameStartsWith(str));

        return customers.stream().map(c -> conversionService.convert(c, CustomerDto.class)).collect(Collectors.toList());
    }

}
