package com.jobsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobsearch.model.Skills;


@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer>{
	 List<Skills> findSkillsByUserId(int userId);
}
