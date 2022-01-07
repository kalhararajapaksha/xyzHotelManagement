package com.nsbm.xyzhotel.ui.service;

import com.nsbm.xyzhotel.ui.model.CustomerDto;
import xyzhotel.model.Customer;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.User;

public interface UserService {

public Response singUp(CustomerDto customer);

public Response signIn(User user);

public Response editProfile(CustomerDto customerDto);

public Response findCustomer(Customer customer);
}

