package com.jobsearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobsearch.model.Languages;


@Service
public interface LanguageServices {
	
	void saveLanguages(Languages languages);
	List<Languages> getLanguageListByUser(int userId);
	List<Languages> displayAllLanguages(int userId);
	void deleteLanguage(int lanId);

}
