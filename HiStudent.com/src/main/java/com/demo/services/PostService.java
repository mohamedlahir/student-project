package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.userrepo.PostRepo;
import com.demo.userrepo.UserRepo;

@Service
public class PostService {

    @Autowired
    PostRepo postRepository; 

    @Autowired
    UserRepo userRepository;


    

}