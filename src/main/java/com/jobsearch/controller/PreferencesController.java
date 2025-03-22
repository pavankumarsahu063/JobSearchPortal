package com.jobsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobsearch.model.JobPreferences;
import com.jobsearch.model.Users;
import com.jobsearch.service.JobPreferencesServices;
import com.jobsearch.service.UserService;

@Controller
public class PreferencesController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private JobPreferencesServices jobPreferencesServices;
	
	@PostMapping("/saveJobPreferences")
	public String saveJobPreferences(@ModelAttribute("jobPreferences") JobPreferences jobPreferences,
			@RequestParam("userId") int userId, Model model) {
		Users user = userService.findById(userId);
		jobPreferences.setUsers(user);
		jobPreferencesServices.saveJobPreferences(jobPreferences);
		userController.populateModel(model, user, userId);
		return "user/JobPreferences";
	}
	
	@PostMapping("/jobpreferenceDetails")
	public String showJobPrefernces(@RequestParam("userId") int userId,Model model) {
		Users user = userService.findById(userId);
	JobPreferences jobPreferences=	jobPreferencesServices.getJobPreferences(userId);
	model.addAttribute("jobPreferencesList", jobPreferences);
	userController.populateModel(model, user, userId);
	return "user/JobPreferences";	
	}
	@PostMapping("/deleteJobPreferences")
	public String deleteJobPreferance(@RequestParam("id") int id,Model model,@RequestParam("userId") int userId) {
		Users user = userService.findById(userId);
		jobPreferencesServices.deleteJobPreferance(id);
		JobPreferences jobPreferences=	jobPreferencesServices.getJobPreferences(userId);
		model.addAttribute("jobPreferencesList", jobPreferences);
		userController.populateModel(model, user, userId);
		return "user/JobPreferences";	
		
	}
}
