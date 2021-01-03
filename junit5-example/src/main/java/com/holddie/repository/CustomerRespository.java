package com.holddie.repository;

import java.util.List;

import com.holddie.model.Customer;

public interface CustomerRespository {

    List<Customer> findAll();

    Customer findOne(Long id);

    boolean isDataFromMemory();
}
