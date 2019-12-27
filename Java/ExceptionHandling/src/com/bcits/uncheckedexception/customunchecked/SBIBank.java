package com.bcits.uncheckedexception.customunchecked;

import com.bcits.uncheckedexception.customcheckedexception.ATMSimulator;
import com.bcits.uncheckedexception.customcheckedexception.InsufficientBalance;

public class SBIBank
{
	public static void main(String[] args) {
        System.out.println("main started");
		ATMSimulator a1=new ATMSimulator();
		try {
			a1.withdraw(41000);
		}
		catch(InsufficientBalance e)
		{
			System.out.println(e.getMessage());
		}
		  System.out.println("main ended");
	}
}