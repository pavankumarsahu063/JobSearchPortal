package com.jobsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.jobsearch.model.Achievents;
import com.jobsearch.model.BasicInformation;
import com.jobsearch.model.Certification;
import com.jobsearch.model.Education;
import com.jobsearch.model.JobPreferences;
import com.jobsearch.model.Languages;
import com.jobsearch.model.Projects;
import com.jobsearch.model.Skills;
import com.jobsearch.model.Users;
import com.jobsearch.model.WorkExprience;
import com.jobsearch.service.AchieventsService;
import com.jobsearch.service.AchieventsServiceImpl;
import com.jobsearch.service.BasicInformationService;
import com.jobsearch.service.CertificationService;
import com.jobsearch.service.EducationServiceImpl;
import com.jobsearch.service.JobPreferencesServices;
import com.jobsearch.service.LanguageServices;
import com.jobsearch.service.ProjectServices;
import com.jobsearch.service.SkillsService;
import com.jobsearch.service.UserServiceImpl;
import com.jobsearch.service.WorkExprienceService;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private SkillsService skillsService;

	@Autowired
	private LanguageServices languageServices;

	@Autowired
	private BasicInformationService basicInformationService;

	@Autowired
	private ProjectServices projectServices;

	@Autowired
	private WorkExprienceService workExprienceService;

	@Autowired
	private CertificationService certificationService;
	
	@Autowired
	private JobPreferencesServices jobPreferencesServices;
	
	@Autowired
	private AchieventsService achieventsService;
	
	@Autowired
	private BasicInformationService basiInformationService;

	public void populateModel(Model model, Users user, int userId) {
		List<Languages> languageList = languageServices.getLanguageListByUser(userId);
		model.addAttribute("users", user);
		model.addAttribute("education", new Education());
		model.addAttribute("skills", new Skills());
		model.addAttribute("languages", new Languages());
		model.addAttribute("BasicuserInfo", new BasicInformation());
		model.addAttribute("userId", userId);
		model.addAttribute("project", new Projects());
		model.addAttribute("workExperience", new WorkExprience());
		model.addAttribute("certification", new Certification());
		model.addAttribute("jobPreferences", new JobPreferences());
		model.addAttribute("achievement",new Achievents());
	}

	// Registration Page
	@GetMapping("/Registration")
	public String registration(Model model) {
		model.addAttribute("userDetails", new Users());
		return "userregistrationform";
	}

	// Save User Registration Data
	@PostMapping("/saveUser")
	public String saveUserData(@ModelAttribute("userDetails") Users users) {
		System.out.println(users);
		userServiceImpl.saveUsers(users);
		return "redirect:/UserDashBoard?userId=" + users.getId();
	}

	// Handle User Login and Redirect to Dashboard
	@PostMapping("/userdashboard")
	public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
		Users users = userServiceImpl.findByEmailAndPassword(email, password);
		if (users != null) {

			return "redirect:/UserDashBoard?userId=" + users.getId();
		} else {
			model.addAttribute("error", "Invalid email or password.");
			return "index";
		}
	}


	@GetMapping("/UserDashBoard")
	public String userDashboard(@RequestParam("userId") int userId, Model model) {
		Users user = userServiceImpl.findById(userId);
		BasicInformation basiList=basicInformationService.getBasicInformation(userId);
		model.addAttribute("basicInfo", basiList);
		populateModel(model, user, userId);
		
		return "UserDashBoard";
	}
	
	@PostMapping("/submitBasicInfoForm")
	public String saveBasicInformation(@ModelAttribute("BasicuserInfo") BasicInformation basicInformation,
		@RequestParam("userId") int userId, Model model) {
		Users user = userServiceImpl.findById(userId);
		basicInformation.setUsers(user);
		basicInformationService.saveBasicInformation(basicInformation);
		populateModel(model, user, userId);
		return "user/BasicInformationForm";
	}





	@PostMapping("/saveProject")
	public String saveProjects(@ModelAttribute("project") Projects projects, @RequestParam("userId") int userId,
			Model model) {
		Users user = userServiceImpl.findById(userId);
		projects.setUsers(user);
		projectServices.addProjects(projects);
		populateModel(model, user, userId);
		return "UserDashBoard";

	}

	@PostMapping("/saveWorkExperience")
	public String saveworkExprience(@ModelAttribute("workExperience") WorkExprience workExprience,
			@RequestParam("userId") int userId, Model model) {
		Users user = userServiceImpl.findById(userId);
		workExprience.setUser(user);
		workExprienceService.saveWorkExprience(workExprience);
		populateModel(model, user, userId);
		return "UserDashBoard";

	}

	@PostMapping("/saveCertification")
	public String saveCertifications(@ModelAttribute("certification") Certification certification,
			@RequestParam("userId") int userId, Model model) {
		Users user = userServiceImpl.findById(userId);
		certification.setUser(user);
		certificationService.saveCertification(certification);
		populateModel(model, user, userId);
		return "UserDashBoard";
	}

	
	
	@PostMapping("/saveAchievement")
	public String saveAchievements(@ModelAttribute("achievement") Achievents achievents,@RequestParam("userId") int userId,Model model) {
		Users user = userServiceImpl.findById(userId);
		achievents.setUsers(user);
		achieventsService.saveAchieventsData(achievents);
		populateModel(model, user, userId);
		return "UserDashBoard";
	}
	

}
