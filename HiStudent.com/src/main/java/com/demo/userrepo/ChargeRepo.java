package com.demo.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.charge.ChargeModel;

public interface ChargeRepo extends JpaRepository<ChargeModel, Integer> {
	
	ChargeModel findByid(int id);

}
