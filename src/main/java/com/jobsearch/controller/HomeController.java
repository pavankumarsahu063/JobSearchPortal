package com.jobsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.jobsearch.model.Education;
import com.jobsearch.model.Users;
import com.jobsearch.service.UserService;

@Controller
public class HomeController {

	@GetMapping("/home")
    public String home() {
        return "index"; 
    }
	
	


}
