package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.CustomerRepository;
import com.nsbm.xyzhotel.repository.UserRepository;
import com.nsbm.xyzhotel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.Customer;
import xyzhotel.model.User;
import xyzhotel.model.exception.CustomerNotFoundException;
import xyzhotel.model.exception.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer Save(Customer customer) {

        customer = customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer Update(Customer customer) throws CustomerNotFoundException {
        if(FindById(customer.getCustomerID()) == null ){
            throw  new CustomerNotFoundException("This user not found");
        }

            customer = customerRepository.save(customer);


        return null;
    }

    @Override
    public Customer FindById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }
        return  null;

    }

    @Override
    public List<Customer> FindAll() {
        return customerRepository.findAll();
    }
}
