package com.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.repository.ImageRepository;
import com.poc.repository.SeriesRepository;

@Service
public class SeriesService {
	
	@Autowired
    SeriesRepository seriesRepository;  
	
	// CREATE 
		public Series createSeries(Series series) {
		    return (Series) seriesRepository.save(series);
		}
		
		// UPDATE
		public Series updateImage(String Id, Image details) {
		        Series series = (Series) seriesRepository.save(Id);
		        series.setVr(details.getVr());
		        series.setValue(details.getValue());
		       
		        
		        return (Series) seriesRepository.save(series);                                
		}

}
