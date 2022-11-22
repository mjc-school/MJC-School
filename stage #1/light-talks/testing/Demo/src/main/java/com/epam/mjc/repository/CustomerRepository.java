package com.epam.mjc.repository;

import com.epam.mjc.model.Customer;

public class CustomerRepository {

    public Customer find(long customerId) {
        return new Customer();
    }

    public boolean updateCost(long customerId, double cost) {
        return true;
    }
}
