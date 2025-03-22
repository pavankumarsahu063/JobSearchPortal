package com.jobsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobsearch.model.Skills;
import com.jobsearch.model.Users;
import com.jobsearch.service.SkillsService;
import com.jobsearch.service.UserService;

@Controller
public class SkillsController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private SkillsService skillsService;
	
	@Autowired
	private UserController userController;
	
	@PostMapping("/saveSkill")
	public String addSkills(@ModelAttribute("skills") Skills skills, @RequestParam("userId") int userId, Model model) {
		Users user = userService.findById(userId);
		skills.setUser(user);
		skillsService.addSkills(skills);
		List<Skills> skillsList=skillsService.getSkills(userId);
		model.addAttribute("skillsList", skillsList);
		userController.populateModel(model, user, userId);
		return "user/skillsform";
	}
	
	@PostMapping("/viewskills")
	public String showSkills(@RequestParam("userId") int userId,Model model) {
		Users user=userService.findById(userId);
		List<Skills> skillsList=skillsService.getSkills(userId);
		model.addAttribute("skillsList", skillsList);
		userController.populateModel(model, user, userId);
		return "user/skillsform";
	}
	
	@PostMapping("/skillsdelete")
	public String deleteSkills(@RequestParam("userId") int userId,Model model,@RequestParam("skillId") int skillsid) {
		Users user=userService.findById(userId);
		skillsService.deleteSkill(skillsid);
		List<Skills> skillsList=skillsService.getSkills(userId);
		model.addAttribute("skillsList", skillsList);
		userController.populateModel(model, user, userId);
		return "user/skillsform"; 
	}
	
	
	@PostMapping("/updateskill")
	public String updateSkill(@RequestParam("userId") int userId,Model model,@RequestParam("skillId") int skillsid) {
		
		
		return "user/skillsform";
	}

}
