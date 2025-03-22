package com.jobsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobsearch.model.Languages;


@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Integer>{
	 List<Languages> findByUsersId(int userId);
}
