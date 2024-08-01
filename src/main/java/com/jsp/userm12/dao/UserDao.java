package com.jsp.userm12.dao;

import java.util.Optional;

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
}
