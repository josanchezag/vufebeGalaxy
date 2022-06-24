package com.vufebeGalaxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vufebeGalaxy.model.UserApp;

public interface IUserRepository extends JpaRepository<UserApp,String>{
	
	
	public UserApp findByUsername(String username);

}
