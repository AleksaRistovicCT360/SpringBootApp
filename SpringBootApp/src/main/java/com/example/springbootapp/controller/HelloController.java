package com.example.springbootapp.controller;

import com.example.springbootapp.Greeting;
import com.example.springbootapp.appuser.AppUser;
import com.example.springbootapp.model.Hello;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootapp.service.HelloService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {


    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    private List getAllEmployees() {
        return helloService.getAllHello();
    }

    @GetMapping("/hello/{leanguage}")
    private Hello getEmployeeById(@PathVariable("leanguage") String leanguage) {
        return helloService.getHelloByLeanguage(leanguage);
    }

    @PostMapping("/hello")
    private ResponseEntity createNewLeanguage(@RequestBody Hello hello) {
        try {
            helloService.saveOrUpdate(hello);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New Hello World created with id: " + hello.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/hello/{id}")
    private ResponseEntity deleteById(@PathVariable("id") int id) {
        try {
            helloService.delete(id);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Hello World deleted with id: " + id, HttpStatus.OK);
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-rest")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/helloworld")
    public String hello() {
        return "Hello World";
    }

}
