package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.BasicInformation;
import com.jobsearch.repository.BasicInformationRepository;


@Service
public class BasicInformationServiceImple implements BasicInformationService {
	
	@Autowired
	private BasicInformationRepository basicInformationRepository;
	
	@Override
	public void saveBasicInformation(BasicInformation basicInformation) {
		// TODO Auto-generated method stub
		basicInformationRepository.save(basicInformation);
	}

	@Override
	public BasicInformation getBasicInformationByUserId(int userId) {
//		return basicInformationRepository.getBasicInformationByUserId(userId);
		return null;
	}

	@Override
	public BasicInformation getBasicInformation(int userId) {
		return basicInformationRepository.getBasicInformationByUsersId(userId);
	}

	@Override
	public void deleteBasicInfo(int basicInfoId) {
		basicInformationRepository.deleteById(basicInfoId);
		
	}
	

}
