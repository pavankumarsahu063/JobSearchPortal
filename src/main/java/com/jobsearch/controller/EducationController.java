package com.jobsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobsearch.model.Education;
import com.jobsearch.model.Users;
import com.jobsearch.service.EducationService;
import com.jobsearch.service.UserService;


@Controller
public class EducationController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EducationService educationService;
	
	
	@Autowired
	private UserController userController;
	
	
	// Save Education Data and Redirect to Dashboard
		@PostMapping("/saveEduData")
		public String saveEducationData(@ModelAttribute("education") Education education,
				@RequestParam("userId") int userId, Model model) {
			Users user = userService.findById(userId);
			education.setUser(user);
			educationService.addEducationDetails(education);
			userController.populateModel(model, user, userId);
			return "user/EducationDetails";
		}
		
		
		@PostMapping("/educationDetails")
		public String showEducationDetails(Model model, @RequestParam("userId") int userId) {
			Users user = userService.findById(userId);
			List<Education> educationList=educationService.findnByUser(user);
			model.addAttribute("educationList", educationList);
			userController.populateModel(model, user, userId);
			return "user/EducationDetails";
			
		}
		
//		delete
		@PostMapping("/education/delete")
		public String deleteEducation(@RequestParam("eduId") int eduId,Model model,@RequestParam("userId") int userId) {
			educationService.deleteEducationDetails(eduId);
			Users user = userService.findById(userId);
			List<Education> educationList=educationService.findnByUser(user);
			model.addAttribute("educationList", educationList);
			userController.populateModel(model, user, userId);
			return "user/EducationDetails";
		}

}
