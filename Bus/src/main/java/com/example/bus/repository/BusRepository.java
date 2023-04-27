package com.example.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bus.model.BusModel;

@Repository
public interface BusRepository extends JpaRepository<BusModel, Integer>{

}
