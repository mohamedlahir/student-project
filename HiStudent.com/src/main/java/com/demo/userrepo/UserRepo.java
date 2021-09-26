package com.demo.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.usermodel.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer> {
	
	UserModel findByUsername(String username);
	UserModel findUserByEmail(String email);
		
}