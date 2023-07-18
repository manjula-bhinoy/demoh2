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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;  
 
@Entity
@Table  
public class Student   
{  

@Id  
@Column(name="studentId")  
private Long studentId;  
public Long getStudentId() {
	return studentId;
}

public void setStudentId(Long studentId) {
	this.studentId = studentId;
}

public String getNameen() {
	return nameen;
}

public void setNameen(String nameen) {
	this.nameen = nameen;
}

public String getNamear() {
	return namear;
}

public void setNamear(String namear) {
	this.namear = namear;
}

public int getTelephone() {
	return telephone;
}

public void setTelephone(int telephone) {
	this.telephone = telephone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Set<Course> getAssignedCourse() {
	return assignedCourse;
}

public void setAssignedCourse(Set<Course> assignedCourse) {
	this.assignedCourse = assignedCourse;
}

@Column  
private String nameen;   
@Column  
private String namear; 
@Column  
private int telephone;  
@Column  
private String address;
@Column  
private String email;  
 
@ManyToMany()
@JoinTable(name = "student_course", joinColumns = {
@JoinColumn(name = "courseId") }, inverseJoinColumns = {
@JoinColumn(name = "studentId") })
private Set<Course> assignedCourse=new HashSet<>();

}  