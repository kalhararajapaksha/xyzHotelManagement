package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.Customer;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.User;
import xyzhotel.model.exception.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Response save(@RequestBody User user) {

        try {
            user = userService.Save(user);
            return Response.success(user);
        } catch (InvalidUserNameException invalidUserNameException) {
            return Response.fail(invalidUserNameException.getMessage());
        } catch (InvalidPasswordException invalidPasswordException) {
            return Response.fail(invalidPasswordException.getMessage());
        } catch (InvalidUserTypeException invalidUserTypeException) {
            return Response.fail(invalidUserTypeException.getMessage());
        } catch (ExistingUserException existingUserException) {
            return Response.fail(existingUserException.getMessage());
        }
    }

    @PostMapping(value = "/login")
    public Response login(@RequestBody User user) {
        try {
            return Response.success(userService.Login(user));
        } catch (InvalidUserNameException invalidUserNameException) {
            return Response.fail(invalidUserNameException.getMessage());
        } catch (UserNotFoundException userNotFoundException) {
            return Response.fail(userNotFoundException.getMessage());
        } catch (InvalidPasswordException invalidPasswordException) {
            return Response.fail(invalidPasswordException.getMessage());
        }

    }

    @PutMapping
    public Response updateUser(@RequestBody User user) {

        try {
            user = userService.Update(user);
        } catch (UserNotFoundException userNotFoundException) {
            return Response.fail(userNotFoundException.getMessage());
        } catch (InvalidUserNameException invalidUserNameException) {
            return Response.fail(invalidUserNameException.getMessage());
        } catch (InvalidPasswordException invalidPasswordException) {
            return Response.fail(invalidPasswordException.getMessage());
        }
        return Response.success(user);
    }

    @GetMapping(value = "/{userName}")
    public Response userName(@PathVariable String userName) {
        User user = userService.FindByUserName(userName);
        if (user != null) {
            return Response.success(user);
        } else {
            return Response.fail("User Not Exist");
        }
    }



    @GetMapping
    public Response findAll() {
        return Response.success(userService.FindAll());
    }
}
