package com.jsp.userm12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/save")
	public ResponseEntity< ResponseStructure<User>> saveUser(@RequestBody User  user){
		return  service.saveUser(user);
	}
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int userId) {
		return service.findUserById(userId);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int userId,@RequestBody User user){
		return service.updateUser(userId,user);
	}
	@GetMapping("/findbyname")
	public ResponseEntity<ResponseStructure<User>> findUserByName(@RequestParam String userName) {
		return service.findUserByName(userName);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int userId) {
		return service.deleteUserById(userId);
	}
	
	
}
