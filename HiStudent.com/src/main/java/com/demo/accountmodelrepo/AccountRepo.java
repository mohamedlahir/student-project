package com.demo.accountmodelrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.studentaccount.StudentAccount;

public interface AccountRepo extends JpaRepository<StudentAccount, Integer>{

}
