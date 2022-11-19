package com.java.bankapplication.controllers;


import com.java.bankapplication.service.CheckProfile;
import com.java.bankapplication.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {

@Autowired
CheckProfile checkProfile;

@Autowired
ShowService showService;

 @GetMapping(path="/showadmin")
 public String showAdmin(ModelMap model) {
	 model.put("alladmin",checkProfile.getAll("admin"));
		return "showadmin";
 }
 
 @GetMapping(path="/showemp")
 public String showEmp(ModelMap model) {
	 model.put("allemp",checkProfile.getAll("emp"));
	return "showemp";
 }
 
 @GetMapping(path="/showcust")
 public String showCust(ModelMap model) {
	 model.put("allcust",checkProfile.getAll("cust"));
	return "showcust";
 }
}