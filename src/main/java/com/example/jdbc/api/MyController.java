package com.example.jdbc.api;

import com.example.jdbc.api.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    private MyService service;

    public MyController(MyService myService) {
        service = myService;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam (value = "name", required = false) String name) {
        return service.getProductName(name);
    }

    @GetMapping("/persons/by-city")
    public List<Customer> getPersonsByCity(@RequestParam (value = "city", required = false) String city) {
        return service.getPersonsByCity(city);
    }
}