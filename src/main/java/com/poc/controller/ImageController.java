package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.model.Study;

import com.poc.service.ImageServiceImpl;
import com.poc.service.ImageSevice;

@RestController
@RequestMapping("/api")
public class ImageController {

	@Autowired
	 ImageSevice imgService;
	 
	 @RequestMapping(value="/images", method=RequestMethod.POST)
	 public Image createImage(@RequestBody List<Series> list) {
		 System.out.println("Image Controller");
		 
	     return imgService.createImage(list);
	 }
}
