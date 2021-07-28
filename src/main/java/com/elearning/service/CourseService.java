package com.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.elearning.dao.CourseDao;
import com.elearning.models.Course;


@Service
@Transactional
public class CourseService {
	@Autowired
	CourseDao course;
	public List<Course> listAll() {
        return course.findAll();
    }
    public Course find(int Cid)
    {
    	return course.findCourse(Cid);
    }
    public void save(Course Course) {
        course.save(Course);
    }
     
    public Course get(int id) {
        return course.findById(id).get();
    }
     
    public void delete(int id) {
        course.deleteById(id);
    }
    public List<Course> enrolledCourses(int Uid)
    {
    	return course.findEnrolledCourse(Uid);
    }
    public void updateCourse(String name,String desc,float fees,String res, int cid)
    {
    	course.update(name,desc,fees,res,cid);
    }
}

