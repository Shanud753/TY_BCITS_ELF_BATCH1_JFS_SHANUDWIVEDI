package com.bcits.allprogrammes.collectionclasses;

import java.util.*;

public class Mobile implements Comparable<Mobile>
{
    int price;

	public Mobile(int price) 
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "price:"+price;
	}
    @Override
	public int compareTo(Mobile m) 
	{
		return this.price-m.price;
	}




	
	
    
    
}
