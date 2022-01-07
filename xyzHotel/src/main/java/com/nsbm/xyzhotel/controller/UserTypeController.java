package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.Usertype;
import xyzhotel.model.exception.InvalidUserTypeException;

@RestController
@RequestMapping("/userType")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @PostMapping
    public Response save(@RequestBody Usertype usertype){

        try {
            usertype = userTypeService.Save(usertype);
        }catch (InvalidUserTypeException invalidUserTypeException){
            return  Response.fail(invalidUserTypeException.getMessage());
        }
        return Response.success(usertype);
    }

    @GetMapping(value = "/{userTypeId}")
    public Response findByUserId(@PathVariable int userTypeId){

        Usertype usertype = userTypeService.findById(userTypeId);
        if( usertype != null){
            return Response.success(usertype);
        }
        return Response.fail("invalid user");
    }
}
