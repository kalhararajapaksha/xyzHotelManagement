package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.Customer;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.User;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Response save(@RequestBody Customer customer){

        try {
            customer = customerService.Save(customer);
        }catch (Exception e){
            return Response.fail(e);
        }
        return Response.success(customer);
    }

    @PutMapping
    public  Response update(@RequestBody Customer customer){
        try {
            customer = customerService.Update(customer);
        }catch (Exception e){
            return Response.fail(e);
        }
        return Response.success(customer);

    }

    @GetMapping(value = "/customerID")
    public Response customer(@RequestBody Customer customer){

        customer = customerService.FindById(customer.getCustomerID());
        if (customer != null) {
            return Response.success(customer);
        } else {
            return Response.fail("customer Not Exist");
        }
    }

    @GetMapping
    public Response findAll() {
        return Response.success(customerService.FindAll());
    }


}
