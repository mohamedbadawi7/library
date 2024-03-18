package com.system.library.service;

import com.system.library.dao.AuthRepo;
import com.system.library.entity.Authorities;
import com.system.library.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    public AuthRepo repo;

    @Override
    public List<Authorities> findAll() {
        return repo.findAll();
    }

    public Authorities findById(int id) {

        Optional<Authorities> result = repo.findById(id);
        Authorities newAuth = null;

        if (result.isPresent()) {
            newAuth = result.get();
        }
        else {
            throw new RuntimeException("Did not find user - " + id);
        }
        return newAuth;
    }

    /*
    @Override
    public Authorities findByUsername(String username) {

        Optional<Authorities> result = repo.findById(username);
        Authorities newAuth = null;

        if (result.isPresent()) {
            newAuth = result.get();
        }
        else {
            throw new RuntimeException("Did not find username - " + username);
        }

        return newAuth;
    }

     */


    @Transactional
    @Override
    public Authorities save(Authorities newAuth) {
        return repo.save(newAuth);
    }




}
