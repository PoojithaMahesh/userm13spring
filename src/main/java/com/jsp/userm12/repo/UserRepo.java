package com.jsp.userm12.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.userm12.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    @Query("select u from User u where u.name=?1")
	User findbyName(String userName);

}
