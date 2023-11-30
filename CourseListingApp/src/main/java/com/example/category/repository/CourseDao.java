package com.example.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.category.entities.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

	
	@Query("SELECT c FROM Course c") 
	List<Course> viewCourses();

	
}
