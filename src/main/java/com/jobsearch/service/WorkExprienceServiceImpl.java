package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.WorkExprience;
import com.jobsearch.repository.WorkExprienceRepository;


@Service
public class WorkExprienceServiceImpl implements WorkExprienceService{
	
	@Autowired
	private WorkExprienceRepository workExprienceRepository;

	@Override
	public void saveWorkExprience(WorkExprience workExprience) {
		// TODO Auto-generated method stub
		workExprienceRepository.save(workExprience);
		
	}

}
