package com.kalima.addressbook.address;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.kalima.addressbook.utils.ConstantUtils;




@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;
	@Size(min=3, max=30, message="Please enter between {min}-{max} xters")
	@Pattern(regexp=ConstantUtils.CHAR_PATTERN, message="Please enter Characters only")
	private String country;
	@NotBlank(message="Should not be empty")
	@Size(min=3, max=30, message="Please enter between {min}-{max} xters")
	private String city;
	@Size(min=3, max=60, message="Please enter between {min}-{max} xters")
	private String street;
	@NotBlank(message="Should not be empty")
	@Size(min=3, max=20, message="Please enter between {min}-{max} xters")
	private String boxNumber;
	private  int userid;	
//	//we will create one transient field for userid
//	
//	@ManyToOne
//	@JoinColumn(name="userid")
//	private User user
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Address(int addressid, String country, String city, String street, String boxNumber, int userid) {
	super();
	this.addressid = addressid;
	this.country = country;
	this.city = city;
	this.street = street;
	this.boxNumber = boxNumber;
	this.userid = userid;
}




	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", boxNumber=" + boxNumber + ", userid=" + userid + "]";
	}




	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getBoxNumber() {
		return boxNumber;
	}


	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}

}
