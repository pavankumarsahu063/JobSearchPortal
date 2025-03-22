package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.Projects;
import com.jobsearch.repository.ProjectRepository;

@Service
public class ProjectsServiceImpl implements ProjectServices{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public void addProjects(Projects projects) {
		projectRepository.save(projects);		
	}
	
	

}
