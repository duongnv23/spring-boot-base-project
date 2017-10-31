package com.duongnv.spring.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.duongnv.spring.dao.entity.Authorities;
import com.duongnv.spring.dao.entity.Groups;
import com.duongnv.spring.dao.entity.Users;

public class MyUserPrincipal implements UserDetails {

	private final Users user;

	private final List<GrantedAuthority> authorities = new ArrayList<>();

	public MyUserPrincipal(Users user) {
		super();
		this.user = user;
		extractAuthorities();
	}

	private void extractAuthorities() {
		Map<Long, String> map = new HashMap<>();

		if (user.getAuthoritieses() != null) {
			for (Authorities authority : user.getAuthoritieses()) {
				map.put(authority.getId(), authority.getAuthority());
			}
		}

		if (user.getGroupses() != null) {
			for (Groups group : user.getGroupses()) {
				if (group.getAuthoritieses() != null) {
					for (Authorities authority : group.getAuthoritieses()) {
						map.put(authority.getId(), authority.getAuthority());
					}
				}
			}
		}

		for (Long id : map.keySet()) {
			authorities.add(new SimpleGrantedAuthority(map.get(id)));
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
