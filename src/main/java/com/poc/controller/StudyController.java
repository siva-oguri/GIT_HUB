package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Image;
import com.poc.model.Study;

import com.poc.service.StudyService;

@RestController
@RequestMapping("/api")
public class StudyController {
	
	 @Autowired
	 StudyService studyService;
	 
	 @RequestMapping(value="/studies", method=RequestMethod.POST)
	 public Study createStudy(@RequestBody Study study) {
	     return studyService.createStudy(study);
	 }

}
