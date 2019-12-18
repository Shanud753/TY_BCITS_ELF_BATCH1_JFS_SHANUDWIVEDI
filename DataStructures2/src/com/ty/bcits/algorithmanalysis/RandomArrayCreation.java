package com.ty.bcits.algorithmanalysis;

import java.util.Random;


public class RandomArrayCreation 
{
	public class randomArrayCreation {

	}
	public int[] randomArrayCreation(int size) 
	{
		Random random= new Random();
		int[] intArray=new int[size];
		for(int i=0;i<intArray.length;i++)
		{
			intArray[i]=random.nextInt(100);
			System.out.println("no."+(i+1)+": "+intArray[i]);
			
		}
		return intArray;
	}
	public static void main(String[] args) {
		new RandomArrayCreation().randomArrayCreation(20);
	}
}
