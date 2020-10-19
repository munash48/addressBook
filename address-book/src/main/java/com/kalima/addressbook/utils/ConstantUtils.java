package com.kalima.addressbook.utils;

public class ConstantUtils {
	
	//we define regex to validate some strings
	
	public static final String CHAR_PATTERN ="[a-zA-Z\\s]+";
	public static final String CODE_PATTERN ="[a-zA-Z\\s]+";
	public static final String EMAIL_PATTERN ="[a-zA-Z0-9\\+]+(\\.[_A-Za-z0-9-]+)*@" +
	   "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String PASS_PATTERN = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,80}$";

}
