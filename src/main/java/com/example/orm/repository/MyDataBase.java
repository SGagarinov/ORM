package com.example.orm.repository;

import com.example.orm.entity.Customer;
import com.example.orm.entity.Order;
import com.example.orm.repository.specification.DbSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyDataBase {

    private EntityManager manager;

    public MyDataBase(EntityManager manager) {
        this.manager = manager;
    }


    public String getProductName(String name) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        Root<Customer> root = query.from(Customer.class);
        Join<Customer, Order> order = root.join("orders");

        query.select(order.get("productName"))
                .where(DbSpecification.byCustomerName(name).toPredicate(root, query, builder));
        List<String> result = manager.createQuery(query).getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public List<Customer> getPersonsByCity(String city) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);

        query.select(root)
                .where(DbSpecification.byCityName(city).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }
}
