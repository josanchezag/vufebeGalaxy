package com.vufebeGalaxy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vufebeGalaxy.model.UserApp;
import com.vufebeGalaxy.repository.IUserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private IUserRepository repo;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp usr=repo.findByUsername(username);
		
		
		List<GrantedAuthority> rols= new ArrayList<>();
		rols.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet=new User(usr.getDsNombre(),usr.getPass(),rols);
		
		return userDet;
	}
	
	 
	

}
