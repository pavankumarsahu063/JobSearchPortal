package com.jobsearch.service;

import java.util.List;

import com.jobsearch.model.BasicInformation;

public interface BasicInformationService {
	
	void saveBasicInformation(BasicInformation basicInformation);
	BasicInformation getBasicInformationByUserId(int userId);
	BasicInformation getBasicInformation(int userId);
	void deleteBasicInfo(int basicInfoId);
	

}
