package com.example.orm;

import com.example.orm.entity.Customer;
import com.example.orm.repository.MyDataBase;
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
