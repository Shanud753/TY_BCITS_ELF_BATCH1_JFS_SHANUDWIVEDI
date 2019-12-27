package com.bcits.threads.creatingthread;

public class Thread4 extends Thread{

	public synchronized void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			
			try {
				wait();
			} catch (InterruptedException e) {
				
				System.out.println(e.getMessage());
			}
		}
	
}
	 synchronized void leaveMe() {
		System.out.println("notify called");
		
		notifyAll();
	}
}
