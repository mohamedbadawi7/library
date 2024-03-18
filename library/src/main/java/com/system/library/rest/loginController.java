package com.system.library.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class loginController {


    @GetMapping("/login")
    public String login(Principal principal) {

        return "User " + principal.getName() + " has been logged in";

    }
}
