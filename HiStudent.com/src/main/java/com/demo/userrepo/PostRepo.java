package com.demo.userrepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.usermodel.Post;
import com.demo.usermodel.UserModel;

public interface PostRepo extends JpaRepository<Post,Integer> {
	
	 List<Post> findPostByUserOrderById(UserModel user);

	    List<Post> findAllByOrderByIdDesc();
	    
	    List<Post> findByUser(Optional<UserModel> model1);	    
}