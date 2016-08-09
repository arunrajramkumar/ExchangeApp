package com.test.common.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationDetailsSourceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;


public class AppAuthenticationFilter  extends AbstractAuthenticationProcessingFilter {

    public AppAuthenticationFilter() {
        super("/**");
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = "";
        String password = "";
        
        String authorization = request.getHeader("Authorization");
        System.out.println("authorization _-> "+authorization);
        String[] arr = authorization.split(" ");
        System.out.println(arr[1]);
        byte[] decode = Base64.decode(arr[1].getBytes());
        String decodedCreds = new String(decode);
        System.out.println(decodedCreds);
        
        String [] creds = decodedCreds.split(":");
        
        if(creds.length>1){
        	username = creds[0];
        	password = creds[1];
        }
        
        System.out.format("username %s,  password %s",username,password);
        
        SecurityContext ctx = SecurityContextHolder.getContext();
        
        
        
        //String authToken = header.substring(7);

       // JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,password);
        System.out.println("auth - > "+authentication);
//ctx.setAuthentication(authentication);
        return getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }
}
