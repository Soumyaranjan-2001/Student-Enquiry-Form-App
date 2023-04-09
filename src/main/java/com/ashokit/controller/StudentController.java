package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.binding.*;
import com.ashokit.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	public StudentService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		FormInitBinding(model);
		
		
		return "index";
	}

	private void FormInitBinding(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("Courses", service.getCourses());
		model.addAttribute("PrefTimings", service.getTimings());
	}
	
	@PostMapping("/save")
	public String handleSubmitBtn(Student s ,Model model) {
		
		System.out.println(s);
		model.addAttribute("msg" , "Data saved.....");
		
		FormInitBinding(model);
		
		
		return "index";
	}

}
