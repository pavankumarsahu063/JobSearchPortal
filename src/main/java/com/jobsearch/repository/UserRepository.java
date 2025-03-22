package com.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobsearch.model.Users;


@Repository
public interface UserRepository  extends JpaRepository<Users, Integer> {
	
	
	Users findByEmailAndPassword(String name,String password);
	Users findById(int userId);
	Users findByEmail(String mail);

}
