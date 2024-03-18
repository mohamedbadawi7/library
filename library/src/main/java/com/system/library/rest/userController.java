package com.system.library.rest;

import com.system.library.entity.Authorities;
import com.system.library.entity.User;
import com.system.library.service.AuthServiceImpl;
import com.system.library.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class userController {

    private UserServiceImpl service;


    @Autowired
    public AuthServiceImpl authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public userController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<User> showAllUsers() {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public User showUser(@PathVariable("id") int id) {

        return service.findById(id);

    }


    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {

        String hashPwd = passwordEncoder.encode(user.getPwd());
        user.setPwd(hashPwd);
        User newUser = service.save(user);
        Authorities auth = new Authorities(newUser.getId(), newUser.getUsername(), newUser.getRole());
        authService.save(auth);

        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/")
    public User updateUser(@RequestBody User theUser) {

        String hashPwd = passwordEncoder.encode(theUser.getPwd());
        theUser.setPwd(hashPwd);
        User newUser = service.save(theUser);
        Authorities auth = authService.findById(theUser.getId());
        auth.setUsername(newUser.getUsername());
        auth.setRole(newUser.getRole());
        authService.save(auth);

        return newUser;
    }



}
