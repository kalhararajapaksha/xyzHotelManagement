package com.nsbm.xyzhotel.service;

import xyzhotel.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer Save(Customer customer);

    public  Customer Update(Customer customer);

    public  Customer FindById(int id);

    public List<Customer> FindAll();


}
