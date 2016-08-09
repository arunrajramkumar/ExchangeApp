package com.test.common.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {

	public static void main(String[] args)
	{
		ExecutorService tpE= Executors.newFixedThreadPool(20);
		
		
		long start = System.currentTimeMillis();
		
		Map<String, String> map = new HashMap<String,String>();
		
		System.out.println();
		
		for(int i =0;i<20;i++)
		tpE.submit(new Sample(i));
		
		tpE.shutdown();
		
		try {
			tpE.awaitTermination(20000,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("time taken - > "+(end-start));
	}
	
}

class Sample implements Callable{

	private int Id;
	
	public Sample(int i)
	{
		this.Id = i;
	}
	
	@Override
	public Object call() throws Exception {
		// 
		//Thread.sleep(2000);
		for(long i=1;i<1000000000;i++)
		{
			
		}
		System.out.println("callable executed --> "+Id);
		return null;
	}
	
	
}