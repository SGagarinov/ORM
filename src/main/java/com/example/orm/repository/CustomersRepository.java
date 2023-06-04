package com.example.orm.repository;

import com.example.orm.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByCity (String city);
    List<Customer> findByAgeLessThan(int age, Sort sort);
    Optional<List<Customer>> findByNameAndSurname(String name, String surname);
}
