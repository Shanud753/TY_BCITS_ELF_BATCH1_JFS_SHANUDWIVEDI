package com.bcits.threads.creatingthread;

public class ThreadTest4 {
	public static void main(String[] args) 
	{
		System.out.println("main started");
		Thread4 t1=new Thread4();
		Thread4 t2=new Thread4();
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		
		t1.leaveMe();
		t2.leaveMe();
		System.out.println("main ended");
		
	}
}
