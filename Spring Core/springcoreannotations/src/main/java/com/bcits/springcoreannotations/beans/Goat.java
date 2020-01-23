package com.bcits.springcoreannotations.beans;

import com.bcits.springcoreannotations.interfaces.Animal;

public class Goat implements Animal {

	@Override
	public void eat() {
		System.out.println("Eating grass...");
	}

	@Override
	public void speak() {
		System.out.println("Mehh! Mehh!");
	}


}//End of Class
