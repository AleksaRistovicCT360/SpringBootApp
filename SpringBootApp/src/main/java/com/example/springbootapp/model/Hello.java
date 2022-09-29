package com.example.springbootapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "HELLO")
@ToString
@NoArgsConstructor
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String leanguage;
    private String helloWorld;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeanguage() {
        return leanguage;
    }

    public void setLeanguage(String leanguage) {
        this.leanguage = leanguage;
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }


}
