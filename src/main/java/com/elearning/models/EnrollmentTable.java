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
@Table(name="enrollment")
public class EnrollmentTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EnrollmentId;
	@Column
	private int courseId;
	@Column
	private int userId;
	public int getEnrollmentId() {
		return EnrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		EnrollmentId = enrollmentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
