package com.test.common.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


public class AppAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    

    
    public boolean supports(Class<?> authentication) {
    	System.out.println("inside supportsr method");
        return true;
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        /*JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();

        User parsedUser = jwtUtil.parseToken(token);
*/
       /* if (parsedUser == null) {
            throw new JwtTokenMalformedException("JWT token is not valid");
        }
*/
    	System.out.println("inside retrieveUser method");
        //List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());

       // return new AuthenticatedUser(parsedUser.getId(), parsedUser.getUsername(), token, authorityList);
    	
    	UserDetails userDetails = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return "blackboard";
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return "capella";
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		if(authentication.getPrincipal().equals(userDetails.getUsername())
			&& (authentication.getCredentials().equals(userDetails.getPassword())))
		           System.out.println("authenticated");
			else
				throw new UsernameNotFoundException("user name not found");
		
		
        return userDetails;
    }

}