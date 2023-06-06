package com.example.orm;

import com.example.orm.entity.Customer;
import com.example.orm.repository.CustomersRepository;
import com.example.orm.repository.MyDataBase;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MyService {

    private MyDataBase myDataBase;
    private CustomersRepository customersRepository;

    public MyService(MyDataBase myDataBase, CustomersRepository customersRepository) {
        this.myDataBase = myDataBase;
        this.customersRepository = customersRepository;
    }

    public String getProductName(String name) {
        return myDataBase.getProductName(name);
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
}
