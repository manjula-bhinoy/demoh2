package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;  
 
@Entity
@Table
public class Course {
@Id
@Column(name="courseId")
private Long courseId;
@Column
private String courseName;

@JsonIgnore
@ManyToMany(mappedBy="assignedCourse")
private Set<Student> studentset=new HashSet<>();

public Long getCourseId() {
	return courseId;
}

public void setCourseId(Long courseId) {
	this.courseId = courseId;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public Set<Student> getStudentset() {
	return studentset;
}

public void setStudentset(Set<Student> studentset) {
	this.studentset = studentset;
}

}
