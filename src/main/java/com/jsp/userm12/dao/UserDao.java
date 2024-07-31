package com.jsp.userm12.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userm12.dto.User;
import com.jsp.userm12.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;
	
	public void saveUser(User user) {
		repo.save(user);
	}
}
