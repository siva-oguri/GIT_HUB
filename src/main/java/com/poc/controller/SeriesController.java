package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.model.Study;

import com.poc.service.SeriesService;
import com.poc.service.StudyService;

@RestController
@RequestMapping("/api")
public class SeriesController {
	
	 @Autowired
	 SeriesService seriesService;
	 
	 @RequestMapping(value="/series", method=RequestMethod.POST)
	 public Series createSeries(@RequestBody Series series) {
	     return seriesService.createSeries(series);
	 }

}
