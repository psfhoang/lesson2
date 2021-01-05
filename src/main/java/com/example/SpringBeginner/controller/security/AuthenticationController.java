package com.example.SpringBeginner.controller.security;

import com.example.SpringBeginner.dto.CustomUserDetail;
import com.example.SpringBeginner.dto.LoginReq;
import com.example.SpringBeginner.dto.Register;
import com.example.SpringBeginner.dto.UserDTO;
import com.example.SpringBeginner.entity.User;
import com.example.SpringBeginner.service.CustomUserDetailService;
import com.example.SpringBeginner.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Qualifier("customUserDetailService")
//    @Autowired
//    CustomUserDetailService userDetailsService;
//    @Autowired
//    JWTUtils jwtUtils;
//    @PostMapping("/login")
//    public String request(@RequestBody LoginReq req, HttpServletResponse response){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        req.getUsername(),
//                        req.getPassword()
//                )
//        );
//
//        if(authentication!=null) {
//            response.addHeader("Authorization",jwtUtils.createToken(req.getUsername()));
//            return jwtUtils.createToken(req.getUsername());
//        }
//        return null;
//    }
//
//    @PostMapping("/add")
//    public User add(@RequestBody Register register){
//        return userDetailsService.saveUser(register);
//    }




}
