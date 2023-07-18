package com.example.demo.service;
	 
import java.util.ArrayList;  
	import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;  
	import org.springframework.stereotype.Service;  
	import com.example.demo.entity.Course;  
	import com.example.demo.repository.CourseRepository; 
	import com.example.demo.entity.Student;
import com.example.demo.exception.StudentCourseException;
	
@Service 
public class CourseService {
 
	@Autowired  
	CourseRepository courseRepository;  
	

	//getting all Course records  
	public List<Course> getAllCourse()   
	{  
	List<Course> courses = new ArrayList<Course>();  
	courseRepository.findAll().forEach(course -> courses.add(course));  
	return courses;  
	}  


	//getting a specific record  
	public Course getCourseById(Long id)   
	{  
	return courseRepository.findById(id).get();  
	}  

	public void saveOrUpdate(Course course)   
	{  
		courseRepository.save(course);  
	}  

	//deleting a specific record  
	public void delete(Long id)   
	{  
		courseRepository.deleteById(id);  
	}  
	
	/*public void registerStudentToCourse(Integer courseId, Set<Student> students) {
		//LOG.info("CourseId :: {} , Student :: {}", courseId, students);
		Optional<Course> courseOptional = courseRepository.findById(courseId);
		if (!courseOptional.isPresent()) {
			throw new StudentCourseException("Failed to register Student. Invalid CourseId :: " + courseId);
		}
		Course course = courseOptional.get();
		students.addAll(course.getStudents());
		course.setStudents(students);
		courseRepository.save(course);
	}*/
	public Optional<Course> getCourseByCourseName(String courseName) {
		return courseRepository.findCourseByCourseName(courseName);
	}


	public void updatecourse(Long studentId, Long courseId, Long newcourseId) {
		// TODO Auto-generated method stub
		courseRepository.updatecourse(studentId,courseId,newcourseId);
		
	}

	}  


