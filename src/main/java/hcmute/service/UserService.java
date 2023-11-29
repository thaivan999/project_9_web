package hcmute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.config.*;
import hcmute.entity.*;
import hcmute.repository.*;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void processOAuthPostLogin(String username,  Provider provider) {
		UserEntity existUser = repo.getUserByUsername(username);
		
		if (existUser == null) {
			UserEntity newUser = new UserEntity();
			newUser.setUsername(username);
			newUser.setProvider(provider);
			newUser.setEnabled(true);			
			
			repo.save(newUser);
		}
		
	}
	
}
