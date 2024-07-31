package com.jsp.userm12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.userm12.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
