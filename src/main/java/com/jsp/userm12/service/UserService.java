package com.jsp.userm12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userm12.dao.UserDao;
import com.jsp.userm12.dto.User;
import com.jsp.userm12.exception.UserIdNotFoundException;
import com.jsp.userm12.util.ResponseStructure;
@Service
public class UserService {

	@Autowired
	private UserDao dao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("user data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> findUserById(int userId) {
		User dbUser=dao.findUserById(userId);
		if(dbUser!=null) {
//			user is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("user data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			throw new UserIdNotFoundException("Sorry failed to fetch the User data");
		}
		
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User user) {
	User dbUser=dao.updateUser(userId,user);
	if(dbUser!=null) {
//		user is present
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("user data updated successfully");
		structure.setHttpStatus(HttpStatus.OK.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
	}else {
		throw new UserIdNotFoundException("Sorry failed to update the data");
	}
	}
	public ResponseEntity<ResponseStructure<User>> findUserByName(String userName) {
		User dbUser=dao.findUserByName(userName);
		if(dbUser!=null) {
//			user is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("user data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("Sorry UserName is not present");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
//			try to raise usernamenotfoundexception
			
		}
	}
	public ResponseEntity<ResponseStructure<User>> deleteUserById(int userId) {
		User dbUser=dao.deleteUserById(userId);
		if(dbUser!=null) {
//			user is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("user data deketed successfully");
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FORBIDDEN);
		}else {
			throw new UserIdNotFoundException("Sorry failed to delete the data");
		}
	}

}
