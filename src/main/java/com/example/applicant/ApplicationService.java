package com.example.applicant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository appRep;
	
	public List<Application> getAllApplications(){
		List<Application> appls= new ArrayList<>();
		appRep.findAll().forEach(appls::add);
		return appls;
	}
	
	@Cacheable(value="applicants",key="#id")
	public Application getApplication(String id){
		return appRep.findOne(id);
	}
	
	@CachePut(value="applicants",key="#appl.id")	
	public void addApplication(Application appl){
		appRep.save(appl);
	}
	@CachePut(value="applicants",key="#appl.id")
	public void updateApplication(Application appl){
		appRep.save(appl);
	}
	@CacheEvict(value="applicants",key="id")
	public void deleteApplication(String id){
		appRep.delete(id);
	}
	
}
