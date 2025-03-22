package com.jobsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobsearch.model.Education;
import com.jobsearch.model.Users;
import com.jobsearch.repository.EducationRepository;


@Service
public class EducationServiceImpl implements EducationService{

	@Autowired
	private EducationRepository educationRepository;
	
	@Override
	public void addEducationDetails(Education education) {
			
		educationRepository.save(education);
		
	}

	@Override
	public List<Education> findnByUser(Users user) {
	
		return educationRepository.findByUser(user);
	}

	@Override
	public void deleteEducationDetails(int eduId) {
		educationRepository.deleteById(eduId);
		
	}


	

}
