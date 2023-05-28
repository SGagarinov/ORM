package com.example.jdbc.api;

import com.example.jdbc.api.entity.Customer;
import com.example.jdbc.api.repository.MyDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyService {

    private MyDataBase myDataBase;

    public MyService(MyDataBase myDataBase) {
        this.myDataBase = myDataBase;
    }

    protected String getProductName(String name) {
        return myDataBase.getProductName(name);
    }

    protected List<Customer> getPersonsByCity(String city) {
        return myDataBase.getPersonsByCity(city);
    }
}
