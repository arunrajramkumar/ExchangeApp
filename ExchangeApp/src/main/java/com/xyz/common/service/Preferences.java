package com.xyz.common.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
  User preferences, using a read-write lock. 
  
 <P>The context: preference information is read in upon startup.
 The config data is 'read-mostly': usually, a caller simply reads the 
 information. It gets updated only occasionally. 
 
 <P>Using a read-write lock means that multiple readers can access the 
 same data simultaneously. If a single writer gets the lock, however, then 
 all other callers (either reader or writer) will block until the lock is 
 released by the writer.
 
  <P>(In practice, Brian Goetz reports that the implementation of ConcurrentHashMap 
  is so good that it would likely suffice in many cases, instead of a read-write lock.)
*/
public final class Preferences {
	
	  //...elided
	  
	  // PRIVATE
	  
	  /** Holds the preferences as simple name-value pairs of Strings. */
	  private final Map<String, String> fPreferences = new LinkedHashMap<>();
	  private final ReentrantReadWriteLock fLock = new ReentrantReadWriteLock();
	  private final Lock fReadLock = fLock.readLock();
	  private final Lock fWriteLock = fLock.writeLock();
	

  
  /** Fetch a setting - this is the more common operation.  */
  public String fetch(String aName){
    String result = "";
    fReadLock.lock();
    try {
    	System.out.println("fetch-->"+aName);
      result = fPreferences.get(aName);
      System.out.println("-->"+result);
    }
    finally {
      fReadLock.unlock();
    }
    return result;
  }
 
  /** Change a setting - this is the less common operation. */
  public void update(String aName, String aValue){
    fWriteLock.lock();
    try {
    	System.out.println("update start ->"+aName);
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      fPreferences.put(aName, aValue);
      System.out.println("update end ->"+aName);
    }
    finally {
      fWriteLock.unlock();
    }
  }
  
  public static void main(String[] args) throws Exception
  {
	  BlockingQueue<Runnable> abQ = new ArrayBlockingQueue<Runnable>(100);
	  
	  ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();
	  
	  
	  ThreadPoolExecutor tpE = new ThreadPoolExecutor(3, 5, 50000, TimeUnit.MILLISECONDS, abQ);
	  
	  final Preferences pfs = new Preferences();
	  
	  for(int i=1;i<=10;i++)
	  {
		  final int j = i;
		  if(i%2!=0){
			  threadPoolExecutor.execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				pfs.update(j+"", "arun"+j);
			}
			  
		  });
		  }
		  else
		  {
			  threadPoolExecutor.execute(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						int k = j;
						k--;
						pfs.fetch(k+"");
					}
					  
				  });
		  }
	  }
	  
	  threadPoolExecutor.execute(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				pfs.update(1+"", "arun"+1);
			}
			  
		  });
	  threadPoolExecutor.shutdown();
	  
  }
 
}
 
