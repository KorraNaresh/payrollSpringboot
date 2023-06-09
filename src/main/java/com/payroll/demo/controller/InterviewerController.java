package com.payroll.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.demo.entity.Interviewer;
import com.payroll.demo.repository.InterviewerRepo;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class InterviewerController {
		
	
	@Autowired
	private InterviewerRepo interviewerrepo;
	
	// get all employees
		@GetMapping("/interviewer") 
		public List<Interviewer> getAllEmployees(){
			return interviewerrepo.findAll();
		}
		
	
	// create employee rest api
		@PostMapping("/interviewer")
		public Interviewer createInterviewer(@RequestBody Interviewer interviewer) {
			String stati = "INT";
		    String employeeid = String.format("%03d", Integer.parseInt(interviewer.getEmployeeid()));
		    String result = stati.concat(employeeid);
		    interviewer.setInterviewerid(result);
			return interviewerrepo.save(interviewer);
			
		}
		
}
