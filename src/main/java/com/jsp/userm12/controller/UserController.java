package com.jsp.userm12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.userm12.dao.UserDao;
import com.jsp.userm12.dto.User;

@RestController
public class UserController {

	@Autowired
	private UserDao dao;
	
	@RequestMapping("/save")
	public void saveUser(@RequestBody User  user){
		dao.saveUser(user);
	}
}
