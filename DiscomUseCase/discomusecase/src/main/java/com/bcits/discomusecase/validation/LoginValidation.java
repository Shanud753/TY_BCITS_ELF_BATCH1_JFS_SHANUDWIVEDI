package com.bcits.discomusecase.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {

	public boolean checkRNumber(String rrNumber) {
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~a-z]");
		Matcher hasSpeical = special.matcher(rrNumber);
		if (rrNumber == null || rrNumber.isEmpty()) {
			return true;
		} else if (hasSpeical.find()) {
			return true;
		}
		return false;
	}// end of rrNumberValidation()

	
//	  public boolean checkPassword(String password) {
//	  
	  
		
//		  Matcher hasSpeical =
//		  password.matcher("/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$/");
		 
	  
	  }
	 

