package com.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "parent")
public class Parent_info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fatherName;
	private String motherName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "Parent_info [id=" + id + ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
	}


}
