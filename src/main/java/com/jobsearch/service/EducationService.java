package com.jobsearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobsearch.model.Education;
import com.jobsearch.model.Users;


@Service
public interface EducationService {
	void addEducationDetails(Education education);
	List<Education> findnByUser(Users user);
	void deleteEducationDetails(int eduId);
	 }
