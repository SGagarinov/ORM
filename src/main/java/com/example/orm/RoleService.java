package com.example.orm;

import com.example.orm.entity.Customer;
import com.example.orm.repository.CustomersRepository;
import com.example.orm.repository.RoleDataBase;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    private RoleDataBase roleDataBase;
    private CustomersRepository customersRepository;

    public RoleService(RoleDataBase roleDataBase, CustomersRepository customersRepository) {
        this.roleDataBase = roleDataBase;
        this.customersRepository = customersRepository;
    }

    public String getProductName(String name) {
        return roleDataBase.getProductName(name);
    }

    public List<Customer> getPersonsByCity(String city) {
//        return myDataBase.getPersonsByCity(city);
        return customersRepository.findByCity(city);
    }

    public List<Customer> getPersonByAge(int age) {
        return customersRepository.findByAgeLessThan(age, Sort.by("age"));
    }

    public List<Customer> getByNameAndSurname(String name, String surname) {
        return customersRepository.findByNameAndSurname(name, surname)
                .orElseThrow(() -> new RuntimeException("Персоны не найдены"));
    }

    public Customer getUserName() {
        return new Customer("delete");
    }
}
