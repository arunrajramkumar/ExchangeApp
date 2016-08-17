package com.xyz.common.security;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	
	
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
       System.out.println("inside RestAuthenticationEntryPoint");
    	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
    
   
    public static void commence1() throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
    	int n = 5;
int[][] store = new int[n][3];
   	 for(int i=0;i<n-2;i++)
   	 {
   		 int prev = 0;
   		 for(int j=0;j<3;j++)
   		 {
   			 if(j==0){
				 store[i][j]=store[i][j]+i+1;
				 
				// countStore[store[j][i]]++;
				// colStore[i][store[j][i]]++;
				 }
				 else{
					if(store[i][j-1]+i+1<=n){
						store[i][j]=store[i][j-1]+i+1;
					   //  countStore[store[j][i]]++;
					   //  colStore[i][store[j][i]]++;
					 
					}
					else break;
				 }
   		 }
   		 
   	 }
   	 
   	 for(int i=0;i<n-3;i++)
   	 {
   		 System.out.println(Arrays.toString(store[i]));
   	 }
    	
    }
    
    public static int ways(int n,int m)
    {    
    	
    	System.out.format("(%d,%d) \n",n,m);
    	if(n<=0 || m<=0)
    		return 0;
    	int count = 0;
    	
    	
    	
    	if(m==n)
    		return 1;
    	else if(n==m+1)
    		return 1;
    	else if(m==2)
    		return 1;
    	
    	int prevM = 0;
    	int prevN=0;
    	
    	for(int i=n-(m-1);i>0;i--)
    	{
    		
    		if(prevN == n-i && prevM==i && prevM!=0 && prevN!=0){
    		System.out.println("continue - >"+i);
    			continue;
    		}
    		System.out.print(i+" ");
    		int diffCnt =ways((n-i),m-1);
    		System.out.print("diffCnt - "+diffCnt+" ");
    		count = count +  diffCnt;
    		System.out.println("count --> "+count);
    		prevN = i;
    		prevM = n-i;
    		System.out.println();
    	}
    	
    	return count;
    }
    
    public static void main (String[] args) throws Exception
    {
    	System.out.println("ways -- "+ways(10,3));
    	commence1();
    }
}