package com.nsbm.xyzhotel.service;

import xyzhotel.model.Usertype;

import java.util.List;

public interface UserTypeService {

    public Usertype Save(Usertype usertype);

    public Usertype Update(Usertype usertype);

    public Usertype findById(int id);

    public List<Usertype> findByAll();
}
