package com.xyz.common.service;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListExample {

	public static void main(String[] args){
	CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
    threadSafeList.add("Java");
    threadSafeList.add("J2EE");
    threadSafeList.add("Collection");
 
    //add, remove operator is not supported by CopyOnWriteArrayList iterator
    Iterator<String> failSafeIterator = threadSafeList.iterator();
    while(failSafeIterator.hasNext()){
    	String str = failSafeIterator.next();
        System.out.printf("Read from CopyOnWriteArrayList : %s %n", str);
        //failSafeIterator.remove(); //not supported in CopyOnWriteArrayList in Java
        threadSafeList.remove(str);
    }
    
    int num[] = {105,34,8,2,45,1,9,23};
    ListExample tmn = new ListExample();
    tmn.printFirstKMaxNumbers(num,3);

	}
	
	public void printTwoMaxNumbers(int[] nums){
        int maxOne = 0;
        int maxTwo = 0;
        for(int n:nums){
            if(maxOne < n){
                maxTwo = maxOne;
                maxOne =n;
            } else if(maxTwo < n){
                maxTwo = n;
            }
        }
        System.out.println("First Max Number: "+maxOne);
        System.out.println("Second Max Number: "+maxTwo);
    }

	//{5,34,78,2,45,1,99,23};
	public void printFirstKMaxNumbers(int[] nums,int k){
        
        int[] maxNums = new int[k];
        for(int n:nums){
           int f = n;
        	for(int j=0;j<k;j++)
        	{
        		int temp = 0;
        		if(maxNums[j]<f){
        			
        			temp=maxNums[j];
        			
        			maxNums[j]=f;
        			f=temp;
        			
        		}
        	}
        	
        }
       
        for(int j=0;j<k;j++)
    	{
    		System.out.println(maxNums[j]);
    	}
    }

}
