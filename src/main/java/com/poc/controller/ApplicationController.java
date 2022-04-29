package com.poc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.Image;

import com.poc.service.ImageServiceImpl;
import com.poc.service.SeriesService;
import com.poc.service.StudyService;




@RestController
@RequestMapping("/postgressApp")
public class ApplicationController {

@Resource 
ImageServiceImpl imgService;

@Resource 
StudyService studyService;

@Resource 
SeriesService seriesService;

/*
 * @GetMapping(value = "/imageList") public List<Image> geImages() { return
 * imgService.findAll();
 * 
 * }
 */

@PostMapping(value = "/createImg")
public void createImage(@RequestBody String id,Image img) {
 
	imgService.insertImage(id, img);

}
/*
 * @PutMapping(value = "/updateEmp") public void updateEmployee(@RequestBody
 * Employee emp) { employeeService.updateEmployee(emp);
 * 
 * }
 */
/*
 * @PutMapping(value = "/executeUpdateEmp") public void
 * executeUpdateEmployee(@RequestBody Employee emp) {
 * employeeService.executeUpdateEmployee(emp);
 * 
 * }
 */

/*
 * @DeleteMapping(value = "/deleteEmpById") public void
 * deleteEmployee(@RequestBody Employee emp) {
 * employeeService.deleteEmployee(emp);
 * 
 * }
 */


}