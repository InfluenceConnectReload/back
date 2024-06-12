package com.senac.influenceconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.influenceconnect.models.User;
import com.senac.influenceconnect.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public boolean isEmailAvailable(String email) {
		List<User> allUsers = userRepo.findAll();
		
		for (User user : allUsers) {
            if(user.getEmail().equals(email)) {
                return false;
            }
        }
		
		return true;
	}
}
