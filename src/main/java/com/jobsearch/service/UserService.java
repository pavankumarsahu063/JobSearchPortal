package com.jobsearch.service;

import com.jobsearch.model.Users;

public interface UserService {
	
	Users saveUsers(Users users);
	Users findByEmailAndPassword(String email,String password);
	Users findById(int userid);
	

}
