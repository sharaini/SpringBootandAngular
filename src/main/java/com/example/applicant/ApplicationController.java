package com.example.applicant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	@Autowired
	private ApplicationService applService;
	
	@RequestMapping("/applications")
	public List<Application> getAllApplications(){
		return applService.getAllApplications();
	}
	
	@RequestMapping("/applications/{id}")
	public Application getApplication(@PathVariable String id){
		return applService.getApplication(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/applications")
	public void addApplication(@RequestBody Application appl){
		applService.addApplication(appl);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/applications")
	public void updateApplication(@RequestBody Application appl){
		applService.updateApplication(appl);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/applications/{id}")
	public void deleteApplication(@PathVariable String id){
		applService.deleteApplication(id);
	}
	
}
