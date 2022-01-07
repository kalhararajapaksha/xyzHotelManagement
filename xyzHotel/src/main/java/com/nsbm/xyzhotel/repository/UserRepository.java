package com.nsbm.xyzhotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyzhotel.model.User;

import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<User,String> {

   public User findByEmail(String email);

   public User findByEmailOrUsername(String email,String username);


}
