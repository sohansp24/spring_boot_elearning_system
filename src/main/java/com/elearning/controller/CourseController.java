package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.models.Course;
import com.elearning.service.CourseService;


@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseServ;
	@RequestMapping("/add")
	public ModelAndView addCourse()
	{
		return new ModelAndView("addCoursepage","course", new Course());
	}
	@PostMapping("/addCourse")
	public String registerCourse(@Validated @ModelAttribute("course")Course course,BindingResult bindingResult,ModelMap model)
	{
		if (bindingResult.hasErrors()) {
            return "error";
        }
		model.addAttribute("CourseName",course.getCourseName());
		model.addAttribute("CourseFee",course.getCourseFee());
		model.addAttribute("CourseDesc",course.getCourseDesc());
		model.addAttribute("CourseResource",course.getCourseResource());
		model.addAttribute("CourseFee",course.getCourseFee());
		courseServ.save(course);
		return "courseSave";
	}
	
	@RequestMapping("/listAllCourse")
	@ResponseBody
	public String listAllCourses()
	{
		List<Course> courses= courseServ.listAll();
		String code="<center><H1>Listing All Courses</H1><br><br><br><table border=\"3\" cellpadding=\"3\" cellspacing=\"3\"><tr><td>Course Id</td><td>Course Name</td><td>Course Fee</td><td>Course Description</td><td>Course Resource</td><td>Delete Course</td><td>Update Course</td></tr>";
		for (Course ad:courses) {
			code+="<tr><td>"+Integer.toString(ad.getCourseId())+"</td><td>"+ad.getCourseName()+"</td><td>"+ad.getCourseFee()+"</td><td>"+ad.getCourseDesc()+"</td><td><a href= '"+ad.getCourseResource()+"'>Click Here</a></td><td><a href='/course/delete/"+ad.getCourseId()+"'>Click Here</a></td><td><a href='/course/update/"+ad.getCourseId()+"'>Click Here</a></td></tr>";	
		}
		code+="</table></center>";
		return code;
	}
	
	@GetMapping("/listAllCourse/user/{Uid}")
	@ResponseBody
	public String listAllCoursesForUser(@PathVariable("Uid")int Uid)
	{
		List<Course> courses= courseServ.listAll();
		String code="<center><H1>Listing All Courses</H1><br><br><br><table border=\"3\" cellpadding=\"3\" cellspacing=\"3\"><tr><td>Course Id</td><td>Course Name</td><td>Course Fee</td><td>Course Description</td><td>Enroll</td></tr>";
		for (Course ad:courses) {
			code+="<tr><td>"+Integer.toString(ad.getCourseId())+"</td><td>"+ad.getCourseName()+"</td><td>"+ad.getCourseFee()+"</td><td>"+ad.getCourseDesc()+"</td><td><a href= '/enrollment/enroll/"+Uid+"?course_id="+ad.getCourseId()+"'>Click Here</a></td></tr>";	
		}
		code+="</table></center>";
		return code;
	}
	
	@ResponseBody
	@RequestMapping(value="/enrolledCourses/{Uid}",method = RequestMethod.GET)
	public String viewEnrolledCourse(@PathVariable("Uid") String Uid)
	{
		String code;
		List<Course> courses= courseServ.enrolledCourses(Integer.parseInt(Uid));
		code="<center><H1>Listing All Enrolled Courses</H1><br><br><br><table border=\"3\" cellpadding=\"3\" cellspacing=\"3\"><tr><td>Course Id</td><td>Course Name</td><td>Course Fee</td><td>Course Description</td><td>Course Resource</td></tr>";
		for (Course ad:courses) {
			code+="<tr><td>"+Integer.toString(ad.getCourseId())+"</td><td>"+ad.getCourseName()+"</td><td>"+ad.getCourseFee()+"</td><td>"+ad.getCourseDesc()+"</td><td><a href= '"+ad.getCourseResource()+"'>Click Here</a></td></tr>";	
		}
		code+="</table></center>";
		return code;
	}
	@RequestMapping("/delete/{cid}")
	@ResponseBody
	public String delete(@PathVariable("cid")int Cid)
	{	
		courseServ.delete(Cid);
		return "course with id "+Cid+" has been removed";
	}
	
	@RequestMapping("/update/{cid}")
	public ModelAndView update(@PathVariable("cid")int Cid,ModelMap model)
	{	
		ModelAndView mv=new ModelAndView("updateCourse","course",new Course());
		mv.addObject("cid",Cid);
		return mv;
	}
	@GetMapping("/updateSave/{cid}")
	@ResponseBody
	public String update(@Validated @ModelAttribute("course")Course course, @PathVariable("cid")String Cid, BindingResult bindingResult)
	{	
		if(bindingResult.hasErrors())
			return "Error";
		String name;
		String desc;
		float price;
		String res;
		Course tempCourse= courseServ.find(Integer.parseInt(Cid));
		if(course.getCourseName()!="")
			name=course.getCourseName();
		else
			name=tempCourse.getCourseName();
		if(course.getCourseDesc()!="")
			desc=course.getCourseDesc();
		else
			desc=tempCourse.getCourseDesc();
		if (course.getCourseFee()!=0)
			price=course.getCourseFee();
		else 
			price=tempCourse.getCourseFee();
		if (course.getCourseResource()!="")
			res=course.getCourseResource();
		else
			res=tempCourse.getCourseResource();
		System.out.println("H "+name+" "+desc+" "+price+" "+res+" "+Integer.parseInt(Cid));
		courseServ.updateCourse(name, desc, price, res,Integer.parseInt(Cid));
		return "Update Sucessfull";
	}
	
}
