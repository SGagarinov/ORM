package com.example.jdbc.api.repository.specification;

import com.example.jdbc.api.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

public class DbSpecification {

    public static Specification<Customer> byCustomerName(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Customer> byCityName(String city) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cityOfLiving"), city);
    }
}
