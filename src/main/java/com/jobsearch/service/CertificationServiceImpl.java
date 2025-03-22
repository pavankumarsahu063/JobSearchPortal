package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.Certification;
import com.jobsearch.repository.CertificationRepository;

@Service
public class CertificationServiceImpl implements CertificationService{
	
	@Autowired
	private CertificationRepository certificationRepository;

	@Override
	public void saveCertification(Certification certification) {
		certificationRepository.save(certification);
		
	}

}
