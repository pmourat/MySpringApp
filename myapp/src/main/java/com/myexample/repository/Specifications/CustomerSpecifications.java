package com.myexample.repository.Specifications;

import com.myexample.entities.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecifications {

    public static Specification<Customer> nameStartsWith(String str) {
        return (root, query, criteriaBuilder) -> {
            String searchString = str + '%';
                return criteriaBuilder.like(root.get("firstName"), searchString);
            };
    }
}
