package com.example.springbootapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Hello")
@NoArgsConstructor
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String leanguage;
    @Column
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
