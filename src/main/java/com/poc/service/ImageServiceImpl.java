package com.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageSevice {

	@Autowired
	ImageRepository imgRepository;

	/*
	 * // CREATE public Image createImage(List<Image> list) {
	 * System.out.println("Image Servikce"); return (Image)
	 * imgRepository.save(list); }
	 */
	
	
	// UPDATE
	public Image updateImage(String Id, Image details) {
	        Image img = (Image) imgRepository.save(Id);
	        img.setVr(details.getVr());
	        img.setValue(details.getValue());
	       
	        
	        return (Image) imgRepository.save(img);                                
	}


	
	


	public Image insertImage(String Id,Image img) {
		 Image img1 = (Image) imgRepository.save(Id);
	        img.setVr(img.getVr());
	        img.setValue(img.getValue());
	       
	        
	        return (Image) imgRepository.save(img1);  
		
	}


	@Override
	public Image createImage(List<Series> list) {
		// TODO Auto-generated method stub
		System.out.println("Image Servikce");
		return (Image) imgRepository.save(list);
	}




	

	
	

	
}
