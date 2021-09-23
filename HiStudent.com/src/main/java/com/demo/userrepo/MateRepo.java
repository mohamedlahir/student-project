package com.demo.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.usermodel.StudentMate;

public interface MateRepo extends JpaRepository<StudentMate, Integer> {

}
