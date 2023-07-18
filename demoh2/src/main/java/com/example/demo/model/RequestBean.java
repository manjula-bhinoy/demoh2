package com.example.demo.model;

public class RequestBean {
	
	private Long courseId;
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getNewcourseId() {
		return newcourseId;
	}
	public void setNewcourseId(Long newcourseId) {
		this.newcourseId = newcourseId;
	}
	private Long studentId;
	private Long newcourseId;

}
