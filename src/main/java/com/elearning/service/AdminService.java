package com.elearning.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elearning.dao.AdminDao;
import com.elearning.models.Admin;


@Service
@Transactional
public class AdminService {
	@Autowired
	AdminDao admin;
	 
    public List<Admin> listAll() {
        return admin.findAll();
    }
     
    public Admin save(Admin ad ) {
        return admin.save(ad);
    }
     
    public Admin get(int id) {
        return admin.findById(id).get();
        
    }
    public void delete(int id) {
        admin.deleteById(id);
    }
    
    public Admin addAdmin(Admin admin1)
    {
    	return admin.save(admin1);
    }
    
    public List<Admin> loginAdmin(String Email, String Password)
    {
    	return admin.authenticateAdmin(Email, Password);
    	
    }
    public List<Admin> findAdminDetails(String Email)
    {
    	return admin.findDetails(Email);
    }
}
