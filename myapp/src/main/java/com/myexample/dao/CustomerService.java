package com.myexample.dao;

import com.myexample.dto.CustomerDto;
import com.myexample.entities.Customer;
import com.myexample.repository.CustomerRepository;
import com.myexample.repository.Specifications.CustomerSpecifications;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.ConversionService;
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
    private final ModelMapper modelMapper;

//na dw ton spring converter anti gia modelMapper
     public Optional<CustomerDto> getCustomer(UUID customerId) {
         Optional<Customer> customer = customerRepository.findById(customerId);
        return Optional.of(modelMapper.map(customer, CustomerDto.class));
    }

    public List<CustomerDto> getCustomers() {
         List<Customer> customers = customerRepository.findAll();
         return customers.stream().map(c-> modelMapper.map(c, CustomerDto.class)).collect(Collectors.toList());
    }

    // na spasei se create kai update done

    //na ginetai auto generated to id done

    //pagination me ta repos

    // na valw optional parametrous san query params, dld ti ginetai an theloume toys pelates pou ksekinane ta onomata toys me k. na dw specs done


    public void createCustomer(CustomerDto customerDto) {
       Customer customer = conversionService.convert(customerDto, Customer.class);
       customer.setId(UUID.randomUUID());
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
