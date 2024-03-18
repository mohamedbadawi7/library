package com.system.library.service;

import com.system.library.entity.Book;
import com.system.library.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    public User findById(int id);

    User save(User theUser);


}
