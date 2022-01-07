package com.nsbm.xyzhotel.ui.controller.RestController;


import com.nsbm.xyzhotel.ui.model.CustomerDto;
import com.nsbm.xyzhotel.ui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.Customer;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Response saveUser(@RequestBody CustomerDto customer) {
        Response response = userService.singUp(customer);
        return response;
    }

    @PostMapping(value = "/login")
    public Response signIn(@RequestBody User user) {
        Response response = userService.signIn(user);
        return response;
    }
    @PostMapping(value = "/userFindById")
    public Response userfindByID(@RequestBody Customer customer){
        Response response = userService.findCustomer(customer);
        return response;
    }

    @PostMapping(value = "/editProfile")
    public Response edit(@RequestBody CustomerDto customer){

        Response response = userService.editProfile(customer);
        return response;
    }

}
