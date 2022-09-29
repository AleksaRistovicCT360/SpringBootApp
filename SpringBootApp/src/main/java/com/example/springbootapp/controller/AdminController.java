package com.example.springbootapp.controller;

import com.example.springbootapp.appuser.AppUserService;
import com.example.springbootapp.model.Hello;
import com.example.springbootapp.repository.HelloRepository;
import com.example.springbootapp.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/adminPage")
    public String adminPage() {
        UserDetails details = appUserService.loadUserByUsername("admin");
        if (details != null && details.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return "adminPage";
        }
        else {
            return "index";
        }
    }

    @PostMapping("/adminPage")
    @ResponseBody
    public String save(Hello hello) {

        helloService.saveOrUpdate(hello);

        return "Success";
    }
}
