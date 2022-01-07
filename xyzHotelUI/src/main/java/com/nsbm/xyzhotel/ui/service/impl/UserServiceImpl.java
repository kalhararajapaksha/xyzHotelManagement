package com.nsbm.xyzhotel.ui.service.impl;

import com.nsbm.xyzhotel.ui.model.CustomerDto;
import com.nsbm.xyzhotel.ui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyzhotel.model.Customer;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Response singUp(CustomerDto customerDto) {
        //Save User
        User user = new User();
        user.setActive(true);
        user.setEmail(customerDto.getEmail());
        user.setUsername(customerDto.getUsername());
        user.setPassword(customerDto.getPassword());
        user.setUserTypeId(2);//User type - customer (2)

        HttpEntity<User> userHttpEntity = new HttpEntity<>(user);
        ResponseEntity<Response> userResponseEntity = restTemplate
                .exchange("http://localhost:8080/users", HttpMethod.POST, userHttpEntity, Response.class);

        Response userResponse = userResponseEntity.getBody();

        if (!userResponse.isAction()) {
            return userResponse;
        }

        //Save Customer
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setUserName(user.getUsername());

        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(customer);
        ResponseEntity<Response> customerResponseEntity = restTemplate
                .exchange("http://localhost:8080/customers", HttpMethod.POST, customerHttpEntity, Response.class);

        Response customerResponse = customerResponseEntity.getBody();

        return customerResponse;
    }

    @Override
    public Response signIn(User user) {

        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());

        HttpEntity<User> userHttpEntity = new HttpEntity<>(user1);
        ResponseEntity<Response> userResponseEntity =restTemplate
                .exchange("http://localhost:8080/users/login", HttpMethod.POST, userHttpEntity, Response.class);
        Response userResponse = userResponseEntity.getBody();

        return userResponse;
    }

    @Override
    public Response editProfile(CustomerDto customerDto) {

        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setCustomerID(customerDto.getCustomerID());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setCountry(customerDto.getCountry());
        customer.setNic(customerDto.getNic());


        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(customer);
        ResponseEntity<Response> customerResponseEntity =restTemplate
                .exchange("http://localhost:8080/customers", HttpMethod.PUT, customerHttpEntity, Response.class);
        Response customerResponse = customerResponseEntity.getBody();

        return customerResponse;


    }

    @Override
    public Response findCustomer(Customer customer) {
        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(customer);
        ResponseEntity<Response> customerResponseEntity =restTemplate
                .exchange("http://localhost:8080/customers", HttpMethod.GET, customerHttpEntity, Response.class);
        Response customerResponse = customerResponseEntity.getBody();

        return customerResponse;
    }
}
