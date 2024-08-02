package com.jsp.userm12.dao;

import java.util.Optional;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userm12.dto.User;
import com.jsp.userm12.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUserById(int userId) {
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
//			user is present then shall i return user
			User user=optional.get();
			return user;
		}else {
			return null;
		}
	}

	public User updateUser(int userId, User user) {
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
			
			user.setId(userId);
			return repo.save(user);
			
		}else {
			return null;
		}
	}

	public User findUserByName(String userName) {
		User user=repo.findbyName(userName);
		if(user!=null) {
			return user;
		}else {
			return null;
		}
	}

	public User deleteUserById(int userId) {
		Optional<User> optional=repo.findById(userId);
		if(optional.isPresent()) {
			User user=optional.get();
			repo.delete(user);
			return user;
		}else {
			return null;
		}
	}
}
