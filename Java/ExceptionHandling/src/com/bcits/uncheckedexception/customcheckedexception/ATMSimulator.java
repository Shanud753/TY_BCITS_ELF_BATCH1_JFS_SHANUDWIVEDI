package com.bcits.uncheckedexception.customcheckedexception;

public class ATMSimulator
{
	int balance=40000;
	
	public void withdraw(int amount) throws InsufficientBalance
	{
		if(amount<=balance)
		{
			System.out.println("withdraw amount is successfull");
		}
		else
		{
			throw new InsufficientBalance();
		}
	}

}
