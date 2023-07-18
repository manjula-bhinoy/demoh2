package com.example.demo.exception;


public class StudentCourseException extends IllegalStateException {
	private static final long serialVersionUID = 1L;
	
	public StudentCourseException(String message) {
		super(message);
	}
	
	public StudentCourseException(Throwable e) {
		super(e);
	}

}