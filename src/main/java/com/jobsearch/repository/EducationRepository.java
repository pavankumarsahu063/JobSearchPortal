package com.jobsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.jobsearch.model.Education;
import com.jobsearch.model.Users;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{

		List<Education> findByUser(Users user);
}