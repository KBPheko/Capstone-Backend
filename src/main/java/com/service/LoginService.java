package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmail());
		if (result.isPresent()) {
			
			Login ll = result.get();
			
			if (ll.getPassword().equals(login.getPassword())) {
				
				if (ll.getRole().equals("admin")) {
					return "Admin Successfully Logged In";
				} else {
					return "Logged In successfully";
				}
				
			} else {
				return "Invalid Password";
			}
			
		} else {
			return "Email Address Not Found! Try Again";
		}
	}
	
	public String createProfile(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmail());
		
		if(result.isPresent()) {
			return "Profile matches an email address that already exists";
		} else {
			
//			loginRepository.save(login);
//			return "Profile created successfully";
			if (login.getRole().equals("admin")) {
				return "Admin role can't be created";
			} else {
				loginRepository.save(login);
				return "Profile created successfully";
			}
		}
	}

}
