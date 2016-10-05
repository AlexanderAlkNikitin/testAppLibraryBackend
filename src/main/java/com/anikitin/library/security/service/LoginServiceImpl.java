package com.anikitin.library.security.service;

import com.anikitin.library.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.jws.WebService;

/**
 * Created by anikitin on 05.10.2016.
 */
@WebService(endpointInterface = "com.anikitin.library.security.service.LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String getToken(String userName, String password) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-authentication so we can generate token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
        return this.tokenUtils.generateToken(userDetails);
    }
}
