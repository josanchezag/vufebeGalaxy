package com.vufebeGalaxy.controller;

import java.util.List;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vufebeGalaxy.model.UserApp;
import com.vufebeGalaxy.repository.IUserRepository;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
    IUserRepository userRepo;

	
	@GetMapping
    public List<UserApp> getUser(){
    		return userRepo.findAll();
	}
	
	@PostMapping
	public void insertUser()
	{

		userRepo.save(
				new UserApp(1,
						"josanchez",
						"Josimar Sanchez",
						"$2a$12$e7gIjsWoBFOMSECRYCd52OBA0OlgX3wPE4VxBc1hj/pLtcvvpmpDC",
						"S",
						new Date()));
	}
	

}
