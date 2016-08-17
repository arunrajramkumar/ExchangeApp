package com.xyz.common.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;


public class AppLdapAuthProvider extends GenericFilterBean{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain chain) throws IOException, ServletException {
	    //Implement this Function to have your filter working
		System.out.println("inside ldapauthprovider filter");
		  SecurityContext ctx = SecurityContextHolder.getContext();
		
		  UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("sdfsdfit.pccp","sfsdfC@pella5");
        
		ctx.setAuthentication(authentication);
		
		chain.doFilter(request, response);
			
	}
   

}