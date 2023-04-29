package com.example.foodiko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodiko.model.Foodiko;

@Repository
public interface FoodikoRepository extends JpaRepository<Foodiko, Integer>{

}
