package hcmute.security;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hcmute.entity.UserEntity;
import hcmute.repository.UserRepository;

@Service

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> userOpt = userRepo.findByUsername(username);
		UserEntity user = userOpt.get();
		System.out.println(user.getId());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

}
