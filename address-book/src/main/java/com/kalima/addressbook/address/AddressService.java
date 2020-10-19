package com.kalima.addressbook.address;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalima.addressbook.users.User;
import com.kalima.addressbook.users.UserRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Address> getAllAddresses() {
		List<Address> addresses = new ArrayList<>();
		addressRepository.findAll().forEach(addresses::add);
		return addresses;

	}
	

	public String addAddress(Address address) {
		
		String message="";
		
	    JSONObject jsonObject = new JSONObject();
	    
		try {
			if(address.getAddressid()==0) {
				message="Added";
			} else {
				message="Updated";
			}
			
			addressRepository.save(address);
			User user =userRepository.findById(address.getUserid()).orElseThrow(null);
			
			jsonObject.put("status", "success");
			jsonObject.put("title", message+ " Confirmation");
			jsonObject.put("message",  "Address for "+ user.getName()+" " +message +" Successfully");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}

	public Optional<Address> getAddress(int id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id);
	}

	public void updateAddress(int id, Address address) {
		// TODO Auto-generated method stub
		
		addressRepository.save(address);
		
	}


	public String deleteAddress(int id) {
		JSONObject jsonObject = new JSONObject();
		try {
			addressRepository.deleteById(id);
			jsonObject.put("message", "Address Deleted Successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString() ;
		
		
	}
	
	public Optional<User> getUser(int id) {
		
		return userRepository.findById(id);
		
	}


	
	

}
