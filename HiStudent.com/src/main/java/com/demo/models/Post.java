package com.demo.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
	@Table(name = "posts")
	public class Post {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "user_id",referencedColumnName = "id")
	    private UserModel user;

	    @Column(columnDefinition="TEXT")
	    private String content;
	    
//	    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	    private Date createdDate = new Date(1990,9,30);



		public Post() {
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public UserModel getUser() {
	        return user;
	    }

	    public void setUser(UserModel user) {
	        this.user = user;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

		@Override
		public String toString() {
			return "Post [id=" + id + ", user=" + user + ", content=" + content + "]";
		}
	    
	    

	}


