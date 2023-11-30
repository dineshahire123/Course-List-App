package com.example.category.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.category.entities.Course;

@Service
public interface CourseService {

	List<Course> viewCourse();
	
    Course saveCourse(MultipartFile file, Course course);
}