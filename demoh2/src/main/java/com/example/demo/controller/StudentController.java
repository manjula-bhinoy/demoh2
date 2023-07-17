package com.example.demo.controller;
  
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
import com.example.demo.entity.Student;  
import com.example.demo.service.StudentService;  
//creating RestController  
@RestController 
public class StudentController   
{  
//autowired the StudentService class  
@Autowired  
StudentService studentService;  


//creating a get mapping that retrieves all the students detail from the database   
@GetMapping("/studentlist")  
private List<Student> getAllStudent()   
{  
return studentService.getAllStudent();  
}  


//creating a get mapping that retrieves the detail of a specific student  
@GetMapping("/student/{id}")  
private Student getStudent(@PathVariable("id") Long id)   
{  
return studentService.getStudentById(id);  
}  


//creating a delete mapping that deletes a specific student  
@DeleteMapping("/student/{id}")  
private void deleteStudent(@PathVariable("id") Long id)   
{  
studentService.delete(id);  
}  


//creating post mapping that post the student detail in the database  
@PostMapping("/student")  
private Long saveStudent(@RequestBody Student student)   
{  
studentService.saveOrUpdate(student);  
return student.getStudentId();
}  

@PutMapping("/assignCourseToStudent/{studentId}/{courseId}")
private Student assignCourseToStudent(@PathVariable Long studentId,@PathVariable Long courseId)   
{  
return studentService.assignCourseToStudent(studentId,courseId);  

} 

 @GetMapping("/studentsByCourseName/{courseName}") 
 public Set<Student> getStudentsByCourseName(@PathVariable String courseName) { 
	 return studentService.getStudentsByCourseName(courseName); 
	 }
 
}