package com.example.springbootapp.repository;

import com.example.springbootapp.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<Hello, Integer> {

}
