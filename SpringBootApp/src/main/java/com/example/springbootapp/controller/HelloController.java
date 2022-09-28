package com.example.springbootapp.controller;

import com.example.springbootapp.Greeting;
import com.example.springbootapp.model.Hello;
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

    @GetMapping("/hello/{id}")
    private Hello getEmployeeById(@PathVariable("id") int id) {
        return helloService.getHelloById(id);
    }

    @PostMapping("/hello")
    private ResponseEntity createEmployee(@RequestBody Hello employee) {
        try {
            helloService.saveOrUpdate(employee);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New employee created with id: " + employee.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/hello/{id}")
    private ResponseEntity deleteById(@PathVariable("id") int id) {
        try {
            helloService.delete(id);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id: " + id, HttpStatus.OK);
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
