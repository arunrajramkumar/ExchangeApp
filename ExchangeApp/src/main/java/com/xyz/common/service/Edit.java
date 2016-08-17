package com.xyz.common.service;

import java.util.Scanner;

public class Edit {

private static CharStk stack = new CharStk(1000000);
	
	private static StringStk stackStr = new StringStk(1000000);
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String st = new String();
		
		stackStr.push("");
		for(int i=0;i<N;i++)
		{
			int f = sc.nextInt();
			
			switch(f){
			case 1:
				String append = sc.next();
				
				insert(append);
				stackStr.push(stack.getString());
				//System.out.println(stack.getString());
				break;
			case 2:
				delete(sc.nextInt());
				stackStr.push(stack.getString());
				//System.out.println(stack.getString());
				break;
			case 3:
				print(sc.nextInt());
				break;
			case 4:
                if(stackStr.getCurrentPointer()!=-1){
				stackStr.pop();
				String ne = stackStr.peep();
				stack = new CharStk(1000000);
				insert(ne);
                }
				break;
			
		
			}
		}
	}
	
	
	public static void insert(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			stack.push(str.charAt(i));
		}
	}
	
	public static void delete(int k)
	{
		for(int i=0;i<k;i++)
		{
			stack.pop();
		}
	}
	
	public static void print(int k)
	{
		System.out.println((char)stack.peep(k));
		
	}
}

class CharStk {

	
	private  char[] stkArr = null;
		
private static char[] stkMaxArr = null;
	
	private static int maxPointer = 0;
		
		private  int currentPointer =-1;
		
		private int size = 0;
		
		
		
		
		
		public CharStk(int size) {
			super();
			this.size = size;
			stkArr = new char[size];
		}

		public  void push(char x){
			 currentPointer++;
			 stkArr[currentPointer]=x;
			 
			 	
			 
			
			
		}
		
		public  char pop(){
			char val = stkArr[currentPointer]; 
			stkArr[currentPointer]=0;
			 currentPointer--;
			
			
			 
			return val;
			 
			
		}
		
		public int peep(){
			if(currentPointer>-1)
			return stkArr[currentPointer];
			else
				return -99;
		}
		
		public int peep(int i){
			if(currentPointer>=i-1)
			return stkArr[i-1];
			else
				return -99;
		}

		public int getCurrentPointer() {
			return currentPointer;
		}
		
		public int getSize(){
			return size;
		}

		public int getMax(){
			return stkMaxArr[maxPointer];
		}
		
		public String getString()
		{
			String fin = "";
			for(int i=0;i<currentPointer+1;i++)
			{
				fin = fin + stkArr[i];
			}
			return fin;
		}
	}

class StringStk {

	
	private  String[] stkArr = null;
		
private static String[] stkMaxArr = null;
	
	private static int maxPointer = 0;
		
		private  int currentPointer =-1;
		
		private int size = 0;
		
		
		
		
		
		public StringStk(int size) {
			super();
			this.size = size;
			stkArr = new String[size];
		}

		public  void push(String x){
			 currentPointer++;
			 stkArr[currentPointer]=x;
			 
			 	 
			
			
		}
		
		public  String pop(){
			String val = stkArr[currentPointer]; 
			stkArr[currentPointer]="";
			 currentPointer--;
			
			
			 
			return val;
			 
			
		}
		
		public String peep(){
			if(currentPointer>-1)
			return stkArr[currentPointer];
			else
				return "";
		}
		
		public String peep(int i){
			if(currentPointer>=i-1)
			return stkArr[i-1];
			else
				return "";
		}

		public int getCurrentPointer() {
			return currentPointer;
		}
		
		public int getSize(){
			return size;
		}

		
	}


