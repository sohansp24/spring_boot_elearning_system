package com.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.elearning.dao.EnrollmentDao;
import com.elearning.models.EnrollmentTable;

@Service
@Transactional
public class EnrollmentService {
	@Autowired
	EnrollmentDao enroll;
	 
    public List<EnrollmentTable> listAll() {
        return enroll.findAll();
    }
     
    public EnrollmentTable save(EnrollmentTable ad ) {
        return enroll.save(ad);
    }
     
    public EnrollmentTable get(int id) {
        return enroll.findById(id).get();
        
    }
    public void delete(int id) {
        enroll.deleteById(id);
    }
    
//    public List<EnrollmentTable> loginenroll(String Email, String Password)
//    {
//    	return enroll.authenticateenroll(Email, Password);
//    	
//    }
//    public List<enroll> findenrollDetails(String Email)
//    {
//    	return enroll.findDetails(Email);
//    }
}
