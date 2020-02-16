package com.learnspringboot.shop.controller;

import com.learnspringboot.shop.config.JwtTokenUtil;
import com.learnspringboot.shop.models.User;
import com.learnspringboot.shop.models.UserRequest;
import com.learnspringboot.shop.models.UserResponse;
import com.learnspringboot.shop.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tamvo
 * @created 16/02/2020 - 10:45 AM
 */

@Controller
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody UserRequest userRequest) throws Exception {
        authenticate(userRequest.getUsername(), userRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        final UserResponse response = new UserResponse(token);
        return ResponseEntity.ok(response);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
