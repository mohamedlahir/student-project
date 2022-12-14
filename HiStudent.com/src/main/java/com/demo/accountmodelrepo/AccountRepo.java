package com.demo.accountmodelrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.StudentAccount;

public interface AccountRepo extends JpaRepository<StudentAccount, Integer>{

}
