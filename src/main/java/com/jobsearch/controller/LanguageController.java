package com.jobsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobsearch.model.Languages;
import com.jobsearch.model.Users;
import com.jobsearch.service.LanguageServices;
import com.jobsearch.service.UserService;

@Controller
public class LanguageController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private LanguageServices languageServices;
	
	
	@PostMapping("/saveLanguages")
	public String addLanguages(@ModelAttribute("languages") Languages languages, @RequestParam("userId") int userId,
			Model model) {
		Users user = userService.findById(userId);
		languages.setUsers(user);
		languageServices.saveLanguages(languages);
		List<Languages> languagesList=languageServices.displayAllLanguages(userId);
		model.addAttribute("languageList", languagesList);
		userController.populateModel(model, user, userId);
		return "user/Languages";
	}

	@PostMapping("/languageDetails")
	public String showLanguages(@RequestParam("userId") int userId,Model model) {
		Users user=userService.findById(userId);
		List<Languages> languagesList=languageServices.displayAllLanguages(userId);
		model.addAttribute("languageList", languagesList);
		userController.populateModel(model, user, userId);
		return "user/Languages";
	}
	@PostMapping("/languagesdelete")
	public String deleteLanguage(@RequestParam("userId") int userId,Model model,@RequestParam("langId") int langId) {
		languageServices.deleteLanguage(langId);
		Users user=userService.findById(userId);
		List<Languages> languagesList=languageServices.displayAllLanguages(userId);
		model.addAttribute("languageList", languagesList);
		userController.populateModel(model, user, userId);
		return "user/Languages";
	}
}
