package com.elearning.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.elearning.models.User;
import com.elearning.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userServ;
	@RequestMapping("/signup")
	 public ModelAndView addAdmin()
    {
    	return new ModelAndView("userSignup","user", new User());
    }
	@PostMapping(value="/save")
	public String registerUser(@Validated @ModelAttribute("admin")User user,BindingResult bindingResult,ModelMap model)
	{
		if (bindingResult.hasErrors()) {
            return "error";
        }
		Date date=new Date();
		java.sql.Date date2=new java.sql.Date(date.getTime());
		model.addAttribute("Name",user.getName());
		model.addAttribute("EmailId",user.getEmailId());
		model.addAttribute("Address",user.getAddress());
		model.addAttribute("PhoneNumber",user.getPhoneNumber());
		model.addAttribute("Password",user.getPassword());
		model.addAttribute("RegDate",date2.toString());
		user.setRegDate(date2.toString());
		System.out.println(date2.toString());
		userServ.save(user);
		return "userSave";
		
	}
	@RequestMapping("/login")
	public ModelAndView loginView()
    {
    	return new ModelAndView("userLogin","user", new User());
    }
	@PostMapping(value="/validation")
	public ModelAndView adminLogin(@Validated @ModelAttribute("admin")User user,BindingResult bindingResult,ModelMap model)
	{
		if (bindingResult.hasErrors()) {
			return new ModelAndView("invalidUser");
        }
		model.addAttribute("EmailId",user.getEmailId());
		model.addAttribute("Password",user.getPassword());
		User LogedUser=userServ.findUserDetails((user.getEmailId())).get(0);
		model.addAttribute("Name",LogedUser.getName());
		model.addAttribute("Uid",LogedUser.getUid());
		List<User> result=userServ.loginUser(user.getEmailId(),user.getPassword());
	 	if(result.isEmpty())
	 	{
	 		System.out.println("Empty");
	 		return new ModelAndView("invaildUser");
    		
	 	}
	 	System.out.println(result.get(0).getUid());
    	return new ModelAndView("userDashboard","user",user);
	}
	
	@RequestMapping("/listAllUsers")
	@ResponseBody
	public String listUsers()
	{
		System.out.println("Hello");
		List<User> users= userServ.listAll();
		String code="<center><H1>Listing All Users</H1><br><br><br><table border=\"3\" cellpadding=\"3\" cellspacing=\"3\"><tr><td>Id</td><td>Name</td><td>Address</td><td>Phone Number</td><td>Registeration Date</td><td>E-Mail</td></tr>";
		for (User ad:users) {
			code+="<tr><td>"+Integer.toString(ad.getUid())+"</td><td>"+ad.getName()+"</td><td>"+ad.getAddress()+"</td><td>"+Long.toString(ad.getPhoneNumber())+"</td><td>"+ad.getRegDate()+"</td><td>"+ad.getEmailId()+"</td></tr>";	
		}
		code+="</table></center>";
		return code;
	}
	@RequestMapping("/loginFailed")
 	public String LoginFailed()
 	{
 		return "invaildUser";
 	}
	@RequestMapping("/dashboard")
	public String dashboard()
	{
		return "userDashboard";
	}
	
	@RequestMapping("/delete/{Uid}")
	public String deleteAccount(@PathVariable("Uid") String id)
	{
		userServ.delete(Integer.parseInt(id));
		return "userDeleteSuccess";
	}
}
