package com.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobsearch.model.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Integer>{

}
