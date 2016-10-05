package com.anikitin.library.security.service;

import com.anikitin.library.security.TokenUtils;
import com.anikitin.library.security.controller.AuthenticationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory
            .getLogger(LoginServiceImpl.class);
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String getToken(String userName, String password) {
        logger.info("webservice receive login/password");
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
        );
        logger.info("webservice create authentication");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        logger.info("webservice set authentication to SecurityContext");
        // Reload password post-authentication so we can generate token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
        logger.info("webservice receive userDetails from LDAP");
        String token=this.tokenUtils.generateToken(userDetails);
        logger.info("webservice generated token based userDetails");
        return token;
    }
}
