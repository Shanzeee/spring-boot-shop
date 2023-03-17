package com.brvsk.shop.service;

import com.brvsk.shop.model.User;
import com.brvsk.shop.security.UserPrinciple;
import com.brvsk.shop.security.jwt.JwtProvider;
import com.brvsk.shop.service.interfaces.AuthenticationServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationServiceInterface {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(User signInRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrinciple);

        User signInUser = userPrinciple.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }
}
