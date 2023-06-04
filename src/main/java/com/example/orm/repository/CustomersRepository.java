package com.example.orm.repository;

import com.example.orm.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.city=:city")
    List<Customer> findByCity (@Param("city")String city);
    @Query("select c from Customer c where c.age < :age order by age")
    List<Customer> findByAgeLessThan(@Param("age")int age, Sort sort);
    @Query("select c from Customer c where name=:name and surname=:surname")
    Optional<List<Customer>> findByNameAndSurname(@Param("name")String name, @Param("surname")String surname);
}
