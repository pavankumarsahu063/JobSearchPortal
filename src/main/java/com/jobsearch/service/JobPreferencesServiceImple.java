package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.JobPreferences;
import com.jobsearch.repository.JobPreferencesRepository;


@Service
public class JobPreferencesServiceImple implements JobPreferencesServices{
	
	@Autowired
	private JobPreferencesRepository jobPreferencesRepository;

	@Override
	public void saveJobPreferences(JobPreferences jobPreferences) {
		jobPreferencesRepository.save(jobPreferences);
		
		
	}

	@Override
	public JobPreferences getJobPreferences(int userId) {
		
		return jobPreferencesRepository.findByUsersId(userId);
		
	}

	@Override
	public void deleteJobPreferance(int prefId) {
		jobPreferencesRepository.deleteById(prefId);
	}



}
