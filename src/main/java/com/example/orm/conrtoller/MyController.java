package com.example.orm.conrtoller;

import com.example.orm.RoleService;
import com.example.orm.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    private RoleService service;

    public MyController(RoleService roleService) {
        service = roleService;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam (value = "name", required = false) String name) {
        return service.getProductName(name);
    }

    @GetMapping("/persons/by-city")
    public List<Customer> getPersonsByCity(@RequestParam (value = "city", required = false) String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Customer> getPersonsByCity(@RequestParam (value = "age", required = false) int age) {
        return service.getPersonByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public List<Customer> getByNameAndSurname(@RequestParam (value = "name", required = false) String name,
                                              @RequestParam (value="surname", required = false) String surname) {
        return service.getByNameAndSurname(name, surname);
    }
}