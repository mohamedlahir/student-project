package com.demo.usermodel;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "mate")
public class StudentMate {
	
	@Id
	private int id;
	private String userName; 

	@ManyToOne()
	private UserModel model;
	
	/**
	 * @return the model
	 */
	public UserModel getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(UserModel model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "StudentMate [id=" + id + ", userName=" + userName + ", model=" + model + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	

}
