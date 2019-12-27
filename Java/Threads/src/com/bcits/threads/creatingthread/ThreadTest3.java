package com.bcits.threads.creatingthread;

public class ThreadTest3 {

	public static void main(String[] args) 
	{
		System.out.println("main started");
		Thread3 t1=new Thread3();
		t1.start();
		System.out.println("main ended");
		
	}
}
