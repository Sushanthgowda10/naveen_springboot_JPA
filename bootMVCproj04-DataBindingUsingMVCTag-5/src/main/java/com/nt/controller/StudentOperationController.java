package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationController {
	@GetMapping
	public String showHomepage() {
		return "welcome" ;
		
	}
 @GetMapping("/register")
 public String showStudentFormPage() {
	 return "student_register";
 }
	 
	 @PostMapping("/register")
	 public String registerStudent(Map<String,Object>map, @ModelAttribute("stud") Student st) {
		 String grade = null;
		 if (st.getSavg() >= 75)
			 grade = "First Class with Distinction";
		 else if (st.getSavg() >= 60)
			 grade = "First Class";
		 else if (st.getSavg() >= 50)
			 grade = "Second Class";
		 else if (st.getSavg() >= 35)
			 grade = "Third Class";
		 else
			 grade = "Fail";
			 // keep results in Model Attribute
			 map.put("result", grade);
	 return "show_result";
 }
}
