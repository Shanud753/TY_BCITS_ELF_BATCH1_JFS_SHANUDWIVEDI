package com.bcits.uncheckedexception.customcheckedexception;

public class InsufficientBalance extends Exception
{
   String msg="Insufficient balance";

public InsufficientBalance() {
	super();
}

public InsufficientBalance(String msg) {

	this.msg = msg;
}
    public String getMessage()
    {
		return this.msg;
    	
    	
    }
}
