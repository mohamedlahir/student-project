package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.ChargeModel;

public interface ChargeRepo extends JpaRepository<ChargeModel, Integer> {
	
	ChargeModel findByid(int id);

}
