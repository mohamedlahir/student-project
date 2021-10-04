package com.demo.userrepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.usermodel.StudentMate;
import com.demo.usermodel.UserModel;

public interface MateRepo extends JpaRepository<StudentMate, Integer> {

	List <StudentMate> findByUser(String model1);
	
	List<StudentMate> findByUserName(Optional<UserModel> model1);

}
