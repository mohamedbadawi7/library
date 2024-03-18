package com.system.library.service;

import com.system.library.dao.UserRepo;
import com.system.library.entity.Book;
import com.system.library.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    public User findById(int id) {

        Optional<User> result = userRepo.findById(id);
        User newUser = null;

        if (result.isPresent()) {
            newUser = result.get();
        }
        else {
            throw new RuntimeException("Did not find user - " + id);
        }

        return newUser;

    }

    /*
    public User findByUserName(String username) {


        Optional<User> result = userRepo.findById(username);
        User newUser = null;

        if (result.isPresent()) {
            newUser = result.get();
        }
        else {
            throw new RuntimeException("Did not find user - " + username);
        }

        return newUser;
    }

     */


    @Transactional
    @Override
    public User save(User theUser) {
        return userRepo.save(theUser);
    }




}
