package com.demo.userrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.usermodel.Post;
import com.demo.usermodel.UserModel;

public interface PostRepo extends JpaRepository<Post,Integer> {
	
	 List<Post> findPostByUserOrderById(UserModel user);

	    List<Post> findAllByOrderByIdDesc();
}
