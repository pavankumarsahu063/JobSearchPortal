package com.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobsearch.model.JobPreferences;

public interface JobPreferencesRepository extends JpaRepository<JobPreferences, Integer>{
	JobPreferences findByUsersId(int userId);

	
}
