package com.example.springbootapp.service;

import com.example.springbootapp.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootapp.repository.HelloRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {


    public HelloService() {

    }

    @Autowired
    HelloRepository helloRepository;

    public List getAllHello() {
        List hellos = new ArrayList();
        helloRepository.findAll().forEach(hello -> hellos.add(hello));
        return hellos;
    }

    public Hello getHelloById(int id) {
        return helloRepository.findById(id).get();
    }

    public void saveOrUpdate(Hello hello) {
        helloRepository.save(hello);
    }

    public void delete(int id) {
        helloRepository.deleteById(id);
    }
}
