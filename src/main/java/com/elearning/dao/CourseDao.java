package com.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.elearning.models.Course;

@Transactional
public interface CourseDao extends JpaRepository<Course, Integer> {
	@Query(value="SELECT distinct c.course_id,c.course_desc,c.course_fee,c.course_name,c.course_resource from course c LEFT JOIN enrollment e ON c.course_id=e.course_id where e.user_id=?1" , nativeQuery=true)
	public List<Course> findEnrolledCourse(int Uid);
	@Modifying
	@Query(value="UPDATE course SET course.course_name= :name, course.course_desc= :desc, course.course_fee= :fees, course.course_resource= :res WHERE course.course_id= :cid" , nativeQuery=true)
	public void update(String name,String desc,float fees,String res, int cid);
	@Query(value="SELECT * FROM course where course_id=?1" , nativeQuery=true)
	public Course findCourse(int Cid);
}
