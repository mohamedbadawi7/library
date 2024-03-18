package com.system.library.service;

import com.system.library.entity.Authorities;

import java.util.List;
import java.util.Optional;

public interface AuthService {

    List<Authorities> findAll();

    public Authorities findById(int id);

    //public Authorities findByUsername(String username);

    Authorities save(Authorities newAuth);



}
