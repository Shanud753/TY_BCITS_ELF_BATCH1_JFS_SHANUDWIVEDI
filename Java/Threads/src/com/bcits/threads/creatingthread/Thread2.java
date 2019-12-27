package com.bcits.threads.creatingthread;

public class Thread2 implements Runnable{
	public void run()
	{
		System.out.println("Thread is called");
		
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}

}
