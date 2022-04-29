package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.model.Study;
import com.poc.repository.ImageRepository;
import com.poc.repository.SeriesRepository;
import com.poc.repository.StudyRepository;

@Service
public class StudyService {
	
	@Autowired
    StudyRepository studyRepository;  
	
	// CREATE 
			public Study createStudy(Study study) {
			    return (Study) studyRepository.save(study);
			}

			// UPDATE
			public Study updateImage(String Id, Image details) {
			        Series study = (Series) studyRepository.save(Id);
			        study.setVr(details.getVr());
			        study.setValue(details.getValue());
			       
			        
			        return (Study) studyRepository.save(study);                                
			}
}
