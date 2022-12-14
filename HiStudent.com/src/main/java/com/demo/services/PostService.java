package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.PostRepo;
import com.demo.repository.UserRepo;

@Service
public class PostService {

    @Autowired
    PostRepo postRepository; 

    @Autowired
    UserRepo userRepository;


    

}