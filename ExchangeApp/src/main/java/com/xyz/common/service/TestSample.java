package com.xyz.common.service;//

import java.util.LinkedList;

import org.springframework.security.crypto.codec.Base64;




public class TestSample {

	
	public static void testMethod()
	{
		System.out.println("static testMethod");
	}
	
	public static void main(String[] args)
	{
		//{4, 6}, {6, 5}, {7, 3} and {4, 5}
		
		int[] pet = {4,6,7,4};
		
		int[] dis = {6,5,3,5};
		
		  for(int k=0;k<pet.length;k++)
		  {
			  int start = k;
			  int end = k-1;
			  int p = 0;
			  int d = 0;
			  int pass = 0;
			  while(start!=end )
			  {
				 if(pass==0)
				  end++;
				 
				 pass++;
				 p = p + pet[end];
				 d = d + dis[end];
				 
				 System.out.println("p,d"+p+","+d);
				 
				 if(d<p){
					 p=p-d;d=0;}
				 else
					 {
					 System.out.println("break");
					 break;
					 }
					 end++;
				 
				 if(end==pet.length-1)
				 {
					 end = 0;
					 
				 }
				
				 
				 if(start == end){
					 System.out.println("start point -> "+pet[end]+""+dis[end]);
					 break;
				 }
			  }
		  }
	}
}
