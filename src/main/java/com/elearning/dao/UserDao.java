package com.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.elearning.models.User;

public interface UserDao extends JpaRepository<User, Integer> {
	@Query(value="SELECT * FROM user u where u.email_id=?1 and u.password=?2" , nativeQuery=true)
	List<User> authenticateAdmin(String Email,String Password);
	@Query(value="SELECT * FROM user u where u.email_id=?1" , nativeQuery=true)
	List<User> findDetails(String Email);
}
