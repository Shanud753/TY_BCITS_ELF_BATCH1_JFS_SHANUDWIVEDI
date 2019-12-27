package com.bcits.uncheckedexception.customunchecked;

public class AgeLimitException extends RuntimeException {

	String msg="Age is less than 18";

	public AgeLimitException() {
	}


	public AgeLimitException(String msg) {

		this.msg = msg;
	}

       public String getMessage()
       {
		return this.msg;
    	   
       }
}
