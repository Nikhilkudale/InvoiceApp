package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userrepo;
	
	public void adduser(User user)
	{
		userrepo.save(user);
	}

	 public boolean userExistsByEmail(String email) {
	        return userrepo.findByEmail(email) != null;
	    }

	public User findByEmail(String email) {
		return userrepo.findByEmail(email);
	}
	 
	

}
