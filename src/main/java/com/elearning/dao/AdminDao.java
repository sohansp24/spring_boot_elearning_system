package com.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elearning.models.Admin;
public interface AdminDao extends JpaRepository<Admin, Integer> {
	@Query(value="SELECT * FROM admin a where a.email_id=?1 and a.password=?2" , nativeQuery=true)
	List<Admin> authenticateAdmin(String Email,String Password);
	@Query(value="SELECT * FROM admin a where a.email_id=?1" , nativeQuery=true)
	List<Admin> findDetails(String Email);
}	
