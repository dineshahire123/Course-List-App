package com.example.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.category.entities.Course;
import com.example.category.repository.CourseDao;


@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao cDao;


	@Override
	public List<Course> viewCourse() {
		// TODO Auto-generated method stub
		
		List<Course> course = cDao.viewCourses();
		
		return course;
	}

	
	@Override
	public Course saveCourse(MultipartFile file, Course course) {
		// TODO Auto-generated method stub
		
		Course course1 = new Course();
		
		
		course1.setTitle(course.getTitle());
		course1.setImage(file.getOriginalFilename());
		
		cDao.save(course1);
		
		
		return course1;
				
	}

	

	
  
}
