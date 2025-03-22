package com.jobsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobsearch.model.BasicInformation;
import com.jobsearch.model.Users;
import com.jobsearch.service.BasicInformationService;
import com.jobsearch.service.UserService;

@Controller

public class BasicInformationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BasicInformationService basicInformationService;
	
	@Autowired
	private UserController userController;
	
	
	@PostMapping("/BasicDetails")
	public String showUserBasicInfo(Model model, @RequestParam("userId") int userId) {
		
		Users  user=userService.findById(userId);
		BasicInformation basiList=basicInformationService.getBasicInformation(userId);
		model.addAttribute("basicInfo", basiList);
		userController.populateModel(model, user, userId);
		return "user/BasicInformationForm";
	}
	
	@DeleteMapping("/delete")
	public String deleteBasicInfo(@RequestParam("userId") int userId,Model model,@RequestParam("basicInfoId") int basicInfoId) {
		Users  user=userService.findById(userId);
		basicInformationService.deleteBasicInfo(basicInfoId);
		userController.populateModel(model, user, userId);
		return "user/BasicInformationForm";
	}

}
