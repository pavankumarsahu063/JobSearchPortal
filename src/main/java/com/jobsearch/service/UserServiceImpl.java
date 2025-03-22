package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.jobsearch.model.Users;
import com.jobsearch.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users saveUsers(Users users) {
		
	 return userRepository.save(users);
	
	}

	@Override
	public Users findByEmailAndPassword(String email, String password) {
		
		return userRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public Users findById(int userid) {
		
		return userRepository.findById(userid);
	}
	
	
	

}
