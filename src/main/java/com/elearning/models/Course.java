package com.elearning.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CourseId;
	@Column
	private String CourseName;
	@Column
	private String CourseResource;
	@Column
	private String CourseDesc;
	@Column
	private float CourseFee;
	
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCourseResource() {
		return CourseResource;
	}
	public void setCourseResource(String courseResource) {
		CourseResource = courseResource;
	}
	public String getCourseDesc() {
		return CourseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		CourseDesc = courseDesc;
	}
	public float getCourseFee() {
		return CourseFee;
	}
	public void setCourseFee(float courseFee) {
		CourseFee = courseFee;
	}
	
	
}
