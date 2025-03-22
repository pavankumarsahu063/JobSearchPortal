package com.jobsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.Skills;
import com.jobsearch.repository.SkillsRepository;


@Service
public class SkillsServiceImpl implements SkillsService{
	
	@Autowired
	private SkillsRepository skillsRepository;

	@Override
	public void addSkills(Skills skills) {
		skillsRepository.save(skills);
		
	}

	@Override
	public List<Skills> getSkills(int userId) {
		
		return skillsRepository.findSkillsByUserId(userId);
	}

	@Override
	public void deleteSkill(int skillId) {
	skillsRepository.deleteById(skillId);
		
	}

}
