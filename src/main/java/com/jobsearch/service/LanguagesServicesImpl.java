package com.jobsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsearch.model.Languages;
import com.jobsearch.repository.LanguagesRepository;


@Service
public class LanguagesServicesImpl implements LanguageServices{

	
	
	@Autowired
	private LanguagesRepository languagesRepository;
	@Override
	public void saveLanguages(Languages languages) {
		languagesRepository.save(languages);
	}
	@Override
	public List<Languages> getLanguageListByUser(int userId) {
		
		return languagesRepository.findByUsersId(userId);
	}
	@Override
	public List<Languages> displayAllLanguages(int userId) {
		
		return languagesRepository.findByUsersId(userId);
	}
	@Override
	public void deleteLanguage(int lanId) {
		// TODO Auto-generated method stub
		languagesRepository.deleteById(lanId);
		
	}
}
