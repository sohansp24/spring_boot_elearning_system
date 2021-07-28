package com.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.elearning.models.EnrollmentTable;
import com.elearning.service.EnrollmentService;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentServ;
	@RequestMapping(value="/enroll/{Uid}",method = RequestMethod.GET)
	public String enrollUser(@PathVariable("Uid") String Uid ,@RequestParam("course_id") String courseId,ModelMap map) {
		System.out.println("Hello");
		EnrollmentTable enroll = new EnrollmentTable();
		enroll.setCourseId(Integer.parseInt(courseId));
		enroll.setUserId(Integer.parseInt(Uid));
		System.out.println(Uid+"   "+courseId);
		enrollmentServ.save(enroll);
		map.addAttribute("uid",Uid);
		return "/enrollSucess";
	}
	@RequestMapping("/delete")
	public String unenroll(int Cid)
	{
		
		return "unenroll";
	}

}
