package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.models.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer> {
	UserModel findByUsername(String username);
	UserModel findUserByEmail(String email);		
}