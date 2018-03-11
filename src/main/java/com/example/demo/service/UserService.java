package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Users;
import com.example.demo.domain.Verification;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VerificationRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VerificationRepository verificationrepo;
	
	public Map<String, Object> createUser(Users user) {
		Map<String, Object> result = new HashMap<>();
		 String emailId = user.getEmailId();
		 if(isUserExists(emailId)) {
			 result.put("Message", "User already exists");
			 return result;
		 }else {
			 user = userRepository.save(user);
			 String token = UUID.randomUUID().toString();
			 Verification ver = new Verification(user.getId(), user.getEmailId(),token, user.getId());
			 verificationrepo.save(ver);
			 result.put("User", user);
		 }
		 return result;
	}
	
	public boolean isUserExists(String emailId) {
	 Users user=	userRepository.findByEmailId(emailId);
	 if(user != null) return true;
		return false;
	}
}
