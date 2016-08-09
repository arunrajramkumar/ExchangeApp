package com.test.common.service;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] abc = new int[n];
        for(int i=0;i<1;i++)
            {
            
            abc[i]= sc.nextInt();
            sortNext(abc);
        }
    }
    
    public static void sortNext(int[] abc)
        {
        	
        Arrays.sort(abc);
        int min = 0;
        for(int i=0;i<abc.length;i++)
        {
        	int prev = abc[i+1]-abc[i];
        	if(min > 0 && min > prev)
        	{
        		min = prev;
        	}
        }
        
        for(int i=0;i<abc.length;i++)
        {
        	int prev = abc[i+1]-abc[i];
        	if(min == prev)
        	{
        		System.out.println(abc[i]+" "+abc[i+1]);
        	}
        }
        
    }
    
    public static boolean swap(char[] arr,int i)
    {
    	System.out.println(arr[i]);
    	int max = 0;
    	int val = arr[i];
    	int maxPos = -1;
    	for(int j=i+1;j<arr.length;j++)
    	{
    		if(arr[j]>val){
    			if(arr[j]<max)
    			
    				{max=arr[j];}
    			else if(max==0)
    			{
    				max = arr[j];
    				maxPos = j;
    			}
    		}
    	}
    	
    	if(max>0)
    	{
    		System.out.println("max-"+(char)max);
    		arr[i]=(char)max;
    		arr[maxPos]=(char)val;
    	}
    	else{
    		return false;
    	}
    	int temp = 0;
    	int n  = arr.length;
    	 for(int k=i+1;k  < n; k++){
             for(int l=i+2; l < (n-k); l++){
                    
                     if(arr[l-1] > arr[l]){
                             //swap the elements!
                             temp = arr[l-1];
                             arr[l-1] = arr[l];
                             arr[l] = (char)temp;
                     }
                    
             }
     }
    	 
    	 System.out.println(Arrays.toString(arr));
    	 return true;
    }
}
