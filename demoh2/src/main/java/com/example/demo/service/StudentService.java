package com.example.demo.service;
 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.example.demo.entity.Student;
import com.example.demo.exception.StudentCourseException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository; 
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.model.CustomResponse;
import com.example.demo.service.CourseService;
@Service  
public class StudentService   
{  
	@Autowired  
	CourseService courseService;  
@Autowired  
StudentRepository studentRepository;  
@Autowired  
CourseRepository courseRepository; 

//getting all student records  
public List<Student> getAllStudent()   
{  
List<Student> students = new ArrayList<Student>();  
studentRepository.findAll().forEach(student -> students.add(student));  
return students;  
}  


//getting a specific record  
public Student getStudentById(Long id)   
{  
return studentRepository.findById(id).get();  
}  

public void saveOrUpdate(Student student)   
{  
	System.out.println("student"+student);
studentRepository.save(student);  
}  

//deleting a specific record  
public void delete(Long id)   
{  
studentRepository.deleteById(id);  
}  

public Student assignCourseToStudent(Long studentId,Long courseId) {
	Set<Course> courseset=null;
	Student student=studentRepository.findById(studentId).get();
	Course course=courseRepository.findById(courseId).get();
	courseset =student.getAssignedCourse();
	courseset.add(course);
	student.setAssignedCourse(courseset);
	return studentRepository.save(student);
}

public List<Student> getStudent(Long courseId) {
	List<Student> studentset=null;
	Course course=courseRepository.findById(courseId).get();
	studentset=(List<Student>) course.getStudentset();
	return studentset;
}
public Set<Student> getStudentsByCourseName(String courseName) {
	Optional<Course> course = courseService.getCourseByCourseName(courseName);
	if (!course.isPresent()) {
		throw new StudentCourseException("Failed to get Students. Invalid courseName :: " + courseName);
	}
	Comparator<Student> studentByName = (Student student1, Student student2) -> student1.getNameen()
			.compareTo(student2.getNameen());
	TreeSet<Student> sortedStudents = new TreeSet<>(studentByName);

	Set<Student> students = course.get().getStudentset();
	students.forEach(student -> student.getAssignedCourse());
	sortedStudents.addAll(students);
	//LOG.debug("Actual Students :: {} and Sorted Students by Name:: {}", students, sortedStudents);
	return sortedStudents;
}


}  
