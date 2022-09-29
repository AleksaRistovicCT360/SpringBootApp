package com.example.springbootapp.repository;

import com.example.springbootapp.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelloRepository extends JpaRepository<Hello, Integer> {

    Optional<Hello> findByLeanguage(String leanguage);

}
