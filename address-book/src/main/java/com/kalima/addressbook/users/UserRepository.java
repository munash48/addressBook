package com.kalima.addressbook.users;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{ 
	
	User findByEmail(String userName);

}
