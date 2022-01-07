package com.nsbm.xyzhotel.repository;

import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import xyzhotel.model.Usertype;

public interface UserTypeRepository extends JpaRepository<Usertype,Integer>{
}
