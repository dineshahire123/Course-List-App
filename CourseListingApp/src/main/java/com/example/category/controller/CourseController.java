package com.example.category.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.category.entities.Course;
import com.example.category.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	String uploadDirectory = System.getProperty("user.dir")+"src/main/resources/static/webApp/images";

	@GetMapping("/course")
	public ResponseEntity<List<Course>> ViewCourses()
	{
		List<Course> course = courseService.viewCourse();
		
		return new ResponseEntity<List<Course>>(course,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/saveCourse")
	public Course saveCourse(@ModelAttribute Course course, @RequestParam("image") MultipartFile file) throws IOException
	{
		String originalFileName = file.getOriginalFilename();
		
		
		
	  Path fileNameAndPath = Paths.get(uploadDirectory, originalFileName);
		
	   Files.write(fileNameAndPath,file.getBytes()); 
	   
	   course.setImage(originalFileName);
		
		
	   
		Course course1  = courseService.saveCourse(file,course);
		return course1;
		
	}
	
	


	
	
	
}
