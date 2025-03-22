package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.Achievents;
import com.jobsearch.repository.AchieventsReposistory;
@Service
public class AchieventsServiceImpl implements AchieventsService{

	@Autowired
	private AchieventsReposistory achieventsReposistory;
	@Override
	public void saveAchieventsData(Achievents achievents) {
		// TODO Auto-generated method stub
		achieventsReposistory.save(achievents);
		
	}

}
