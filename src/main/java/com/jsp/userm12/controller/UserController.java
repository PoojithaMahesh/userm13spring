package com.jsp.userm12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userm12.dao.UserDao;
import com.jsp.userm12.dto.User;
import com.jsp.userm12.service.UserService;
import com.jsp.userm12.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/save")
	public ResponseEntity< ResponseStructure<User>> saveUser(@RequestBody User  user){
		return  service.saveUser(user);
	}
//	@RequestMapping("/find")
//	public User findUser(@RequestParam int userId) {
//		return service.findUserById(userId);
//	}
	
}
