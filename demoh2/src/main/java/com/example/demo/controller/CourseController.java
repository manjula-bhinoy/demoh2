package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.model.CustomResponse;
import com.example.demo.model.RequestBean;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController 
@SecurityRequirement(name = "javainuseapi")
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	//autowired the CourseService class  
	@Autowired  
	CourseService courseService;  
	@Autowired  
	StudentService studentService;  


	//creating a get mapping that retrieves all the course detail from the database   
	@GetMapping("/courselist")  
	private List<Course> getAllStudent()   
	{  
		logger.info("inside courselist ");
	return courseService.getAllCourse();  
	}  


	//creating a get mapping that retrieves the detail of a specific student  
	@GetMapping("/course/{id}")  
	private Course getCoursebyId(@PathVariable("id") Long id)   
	{  
	return courseService.getCourseById(id);  
	}  


	//creating a delete mapping that deletes a specific course  
	@DeleteMapping("/course/{id}")  
	private void deleteCourse(@PathVariable("id") Long id)   
	{  
		courseService.delete(id);  
	}  


	//creating post mapping that post the course detail in the database  
	@PostMapping("/saveupdatecourse")  
	private Long saveCourse(@RequestBody Course course)   
	{  
	courseService.saveOrUpdate(course);  
	return course.getCourseId();
	}  
	
	@PostMapping("/updatecourseforstudent/{studentId}/{courseId}")  
	private Student updatecourseforstudent(@RequestBody RequestBean req,@PathVariable Long studentId,@PathVariable Long courseId)   
	{  
		System.out.println("req"+req);
		System.out.println("req"+req.getNewcourseId());
	courseService.updatecourse(studentId,courseId,req.getNewcourseId()); 
	return studentService.getStudentById(studentId);  
	}  
	
	//creating a get mapping that retrieves all the course detail from the database   
		@GetMapping("/callcoursewebservice")  
		private ResponseEntity<String> callcoursewebservice(HttpServletRequest request)   
		{  			
			  String uri="http://localhost:8080/courselist";

		try {
			String authTokenHeader = request.getHeader("Authorization");
			URL url = new URL(uri);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Access-Control-Allow-Origin", "*");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			if (authTokenHeader != null) {
				con.setRequestProperty("Authorization", authTokenHeader);
			}
			con.setDoOutput(true);
			StringBuilder response = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				//System.out.println("response: " + response.toString());
			}
			return new ResponseEntity<>(response.toString(), HttpStatus.OK);
		} catch (Exception e) {
			if (e.getMessage().toLowerCase().contains("http response code: 401")) {
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		} 
	
}
