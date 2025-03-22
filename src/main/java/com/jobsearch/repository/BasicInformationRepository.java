package com.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jobsearch.model.BasicInformation;

public interface BasicInformationRepository extends JpaRepository<BasicInformation, Integer>{
	BasicInformation getBasicInformationByUsersId(int userId);
}
