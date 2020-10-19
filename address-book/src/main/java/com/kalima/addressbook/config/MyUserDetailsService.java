package com.kalima.addressbook.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kalima.addressbook.users.User;
import com.kalima.addressbook.users.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user =userRepository.findByEmail(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("User Name "+username +" not found");
		}
		 
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getGrantedAuthorities(user));
	}
	
	private Collection<GrantedAuthority> getGrantedAuthorities(User user){
		
		Collection<GrantedAuthority> grantedAuthorities =new ArrayList<>();
		
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		return grantedAuthorities;
		
	}

}
