package com.nsbm.xyzhotel.service;

import xyzhotel.model.User;
import xyzhotel.model.exception.InvalidPasswordException;
import xyzhotel.model.exception.InvalidUserNameException;
import xyzhotel.model.exception.UserNotFoundException;

import java.util.List;


public interface UserService {

    public User Save(User user) throws UserNotFoundException, InvalidPasswordException;

    public User Update(User user);

    public User FindByUserName(String userName);

    public User FindByEmail(String email);

    public List<User> FindAll();

    public User Login(User user) throws  InvalidUserNameException,
            UserNotFoundException,InvalidPasswordException;
}
