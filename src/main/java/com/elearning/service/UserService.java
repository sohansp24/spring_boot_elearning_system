package com.elearning.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.elearning.dao.UserDao;
import com.elearning.models.User;


@Service
@Transactional
public class UserService {
	@Autowired
	UserDao user;
	
	public List<User> listAll() {
        return user.findAll();
    }
     
    public void save(User User) {
        user.save(User);
    }
     
    public User get(int id) {
        return user.findById(id).get();
    }
     
    public void delete(int id) {
        user.deleteById(id);
    }
    public List<User> loginUser(String Email, String Password)
    {
    	return user.authenticateAdmin(Email, Password);
    	
    }
    public List<User> findUserDetails(String Email)
    {
    	return user.findDetails(Email);
    }
	
}
