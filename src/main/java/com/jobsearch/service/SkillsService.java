package com.jobsearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobsearch.model.Skills;


@Service
public interface SkillsService {
	
	void addSkills(Skills skills);
	List<Skills> getSkills(int userId);
	void deleteSkill(int skillId);

}
