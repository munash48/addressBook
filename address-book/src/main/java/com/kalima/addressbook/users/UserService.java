package com.kalima.addressbook.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;

	}


	public String addUser(User user) {

		String message1 = null;
		JSONObject jsonObject = new JSONObject();
		
	
		
		try {
			if (user.getUserid() == 0) {
				message1 = "Added";
			} else {
				message1 = "Updated";
			}
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
			
			jsonObject.put("status", "success");
			jsonObject.put("title", message1 + " Confirmation");
			jsonObject.put("message", user.getName()+" " +message1 + " successfully");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return jsonObject.toString();
		
	}

	public Optional<User> getUser(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public void updateUser(int id, User user) {
		// TODO Auto-generated method stub

		userRepository.save(user);

	}


	public String deleteUser(int id) {
		JSONObject jsonObject = new JSONObject();
		try {
			userRepository.deleteById(id);
			jsonObject.put("message", "User Deleted Successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString() ;

	}

}
