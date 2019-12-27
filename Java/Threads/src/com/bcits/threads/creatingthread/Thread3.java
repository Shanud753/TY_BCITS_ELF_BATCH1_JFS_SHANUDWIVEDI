package com.bcits.threads.creatingthread;

public class Thread3 extends Thread
{
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

}
