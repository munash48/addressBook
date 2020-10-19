package com.kalima.addressbook.users;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.kalima.addressbook.utils.ConstantUtils;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@NotBlank(message="Should not be empty")
	@Size(min=5, max=30, message="Please enter between {min}-{max} xters")
	private String name;
	@NotBlank(message="Should not be empty")
	@Pattern(regexp=ConstantUtils.EMAIL_PATTERN, message="Please enter correct email format")
	private String email;
	@NotBlank(message="Should not be empty")
	@Pattern(regexp=ConstantUtils.PASS_PATTERN, message="Should have atleast 1 lower, upper, digit and special character")
	private String password;
	private String role;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String name, String email, String password, String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userid=" + userid + ", Name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}





	public String getRole() {
		return role;
	}





	public void setRole(String role) {
		this.role = role;
	}


}
