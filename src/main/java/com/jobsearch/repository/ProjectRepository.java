package com.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobsearch.model.Projects;

public interface ProjectRepository extends JpaRepository<Projects, Integer>{

}
