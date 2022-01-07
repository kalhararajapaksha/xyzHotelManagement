package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.UserRepository;
import com.nsbm.xyzhotel.repository.UserTypeRepository;
import com.nsbm.xyzhotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.User;
import xyzhotel.model.exception.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User Save(User user) throws
            InvalidUserNameException,InvalidPasswordException,
            InvalidUserTypeException,ExistingUserException  {

        //userName
        if (user.getUsername() == null) {
            throw  new InvalidUserNameException("User Name is Cannot be null");
        }

        if (FindByUserName(user.getUsername()) != null) {
            throw  new ExistingUserException("This user name has been already taken");
        }

        //email
        if (user.getEmail() == null) {
            throw  new InvalidEmailException("Email  Cannot be null");
        }

        if (FindByEmail(user.getEmail()) != null) {
            throw  new ExistingUserException("This email is already existing");
        }

        //userType
        if (user.getUserTypeId() > 2 || user.getUserTypeId() < 1 ) {
            throw  new InvalidUserTypeException("Invalid User Type");
        }

        //password
        if (user.getPassword() == null) {
            throw new InvalidPasswordException("Password Can't be Null");
        }

        if (user.getPassword().length() < 5) {
            throw new InvalidPasswordException("Password must be More  5 Later");
        }

        user = userRepository.save(user);

        return user;
    }

    @Override
    public User Update(User user) throws UserNotFoundException, InvalidUserNameException, InvalidPasswordException {

        if(user.getUsername() == null){
            throw  new InvalidUserNameException("User Name is Cannot be null");
        }
        if(user.getUserTypeId() > 1){
            throw  new InvalidUserTypeException("Invalid User Type");
        }

        if(FindByUserName(user.getUsername()) == null){
            throw  new UserNotFoundException("This user not found");
        }

        if (user.getPassword() == null) {
            throw new InvalidPasswordException("Password Can't be Null");
        }

        if (user.getPassword().length() < 5) {
            throw new InvalidPasswordException("Password must be More  5 Later");
        }

        user = userRepository.save(user);
        return user;
    }

    @Override
    public User FindByUserName(String userName) throws  UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userName);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return  null;
    }

    @Override
    public User FindByEmail(String email) {
       /* User optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }*/

        User user=userRepository.findByEmail(email);
        return  user;
    }


    public User findByEmailOrUserName(String email,String username){
        User user=userRepository.findByEmailOrUsername(email,username);
        return  user;
    }

    @Override
    public List<User> FindAll() {
        return userRepository.findAll();
    }

    @Override
    public User Login(User user)
            throws InvalidUserNameException,
            UserNotFoundException,InvalidPasswordException{

        if (user.getUsername() == null && user.getEmail() == null) {
            throw  new InvalidUserNameException("User Name is Cannot be null");
        }
        if (user.getPassword() == null) {
            throw  new InvalidUserNameException("Password Cannot be null");
        }

        User dbUser =findByEmailOrUserName(user.getEmail(),user.getUsername()) ;


        if(dbUser == null){
            throw  new UserNotFoundException("This user not found");
        }

        if(!dbUser.getPassword().equals(user.getPassword())){
            throw new InvalidPasswordException("Invalid Password");
        }

        return user;
    }
}
