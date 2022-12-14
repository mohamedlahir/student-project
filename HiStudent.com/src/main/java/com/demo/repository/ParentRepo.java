package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.models.Parent_info;

public interface ParentRepo extends JpaRepository<Parent_info, Integer> {

}
