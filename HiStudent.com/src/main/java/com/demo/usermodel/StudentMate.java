package com.demo.usermodel;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "friends")
public class StudentMate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String friendName;

//	@ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "friend_id",referencedColumnName = "id")

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "friend_id", referencedColumnName = "id") // @OneToMany not working
	private UserModel user;

	/**
	 * @return the friendName
	 */
	public String getFriendName() {
		return friendName;
	}

	/**
	 * @param friendName the friendName to set
	 */
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	/**
	 * @return the user
	 */
	public UserModel getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "StudentMate [id=" + id + ", userName=" + userName + ", friendName=" + friendName + ", user=" + user
				+ "]";
	}

	public StudentMate() {

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
