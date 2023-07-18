package com.example.demo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	public Optional<Course> findCourseByCourseName(String courseName);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE student_course u SET u.COURSE_ID=:newcourseId where u.STUDENT_ID=:studentId and u.COURSE_ID=:courseId", nativeQuery = true)
	public int updatecourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId, @Param("newcourseId") Long newcourseId);

}
