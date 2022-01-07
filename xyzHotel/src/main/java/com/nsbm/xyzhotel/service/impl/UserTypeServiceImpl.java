package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.UserTypeRepository;
import com.nsbm.xyzhotel.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.Usertype;
import xyzhotel.model.exception.InvalidUserTypeException;
import xyzhotel.model.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public Usertype Save(Usertype usertype) throws InvalidUserTypeException{

        if(usertype.getUserType() == null){
            throw new InvalidUserTypeException("User type can't be null");
        }
        usertype = userTypeRepository.save(usertype);
        return null;
    }

    @Override
    public Usertype Update(Usertype usertype) {
        return null;
    }

    @Override
    public Usertype findById(int id) {
        Optional<Usertype> optionalUsertype = userTypeRepository.findById(id);
        if(optionalUsertype.isPresent()) {
            return optionalUsertype.get();
        }else{

        }
        return null;
    }

    @Override
    public List<Usertype> findByAll() {
        return userTypeRepository.findAll();
    }
}
