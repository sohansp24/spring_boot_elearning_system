package com.elearning.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elearning.models.Admin;
import com.elearning.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminserve;
	
	@RequestMapping("/signup")
    public ModelAndView addAdmin()
    {
    	return new ModelAndView("signup","admin", new Admin());
    }
	@Transactional
	@PostMapping(value="/save")
	public String registerAdmin(@Validated @ModelAttribute("admin")Admin admin,BindingResult bindingResult,ModelMap model)
	{
		if (bindingResult.hasErrors()) {
            return "error";
        }
		model.addAttribute("Name",admin.getName());
		model.addAttribute("EmailId",admin.getEmailId());
		model.addAttribute("Password",admin.getPassword());
		adminserve.save(admin);
		return "adminSave";
		
	}
	@RequestMapping("/viewall")
	@ResponseBody
	public String viewAllAdmin()
	{
		System.out.println("Hello");
		List<Admin> admins= adminserve.listAll();
		String code="<center><H1>Listing All Admins</H1><br><br><br><table border=\"3\" cellpadding=\"3\" cellspacing=\"3\"><tr><td>Id</td><td>Name</td><td>E-Mail</td><td>Remove Admin</tr>";
		for (Admin ad:admins) {
			code+="<tr><td>"+Integer.toString(ad.getAdminId())+"</td><td>"+ad.getName()+"</td><td>"+ad.getEmailId()+"</td><td><a href= '/admin/delete/"+ad.getAdminId()+"'>Click Here</a></tr>";	
		}
		code+="</table></center>";
		return code;
	}
	@RequestMapping("/login")
	public ModelAndView loginView()
    {
    	return new ModelAndView("adminLogin","admin", new Admin());
    }
	@PostMapping(value="/validation")
	public ModelAndView adminLogin(@Validated @ModelAttribute("admin")Admin admin,BindingResult bindingResult,ModelMap model)
	{
		if (bindingResult.hasErrors()) {
			return new ModelAndView("invalid");
        }
		model.addAttribute("EmailId",admin.getEmailId());
		model.addAttribute("Password",admin.getPassword());
		Admin LogedAdmin=adminserve.findAdminDetails((admin.getEmailId())).get(0);
		model.addAttribute("Name",LogedAdmin.getName());
		model.addAttribute("AdminId", LogedAdmin.getAdminId());
		List<Admin> result=adminserve.loginAdmin(admin.getEmailId(), admin.getPassword());
	 	if(result.isEmpty())
	 	{
	 		System.out.println("Empty");
	 		return new ModelAndView("invaildAdmin");
    		
	 	}
	 	System.out.println(result.get(0).getAdminId());
    	return new ModelAndView("adminDashboard","admin",admin);
	}
	@RequestMapping("/loginFailed")
 	public String LoginFailed()
 	{
 		return "invaildAdmin";
 	}
	
	@RequestMapping("/dashboard")
	public String dashboard()
	{
		return "adminDashboard";
	}
	
	@RequestMapping("/delete/{Aid}")
	public String deleteAccount(@PathVariable("Aid") String id)
	{
		adminserve.delete(Integer.parseInt(id));
		return "deleteSuccess";
	}
	
}
