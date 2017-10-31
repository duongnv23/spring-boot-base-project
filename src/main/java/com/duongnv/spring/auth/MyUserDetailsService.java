package com.duongnv.spring.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.duongnv.spring.dao.entity.Users;
import com.duongnv.spring.dao.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users activeUser = usersRepository.findActiveUser(username);

		if (activeUser == null) {
			throw new UsernameNotFoundException(String.format("Username %s is not found", username));
		}

		return new MyUserPrincipal(activeUser);

	}

}
