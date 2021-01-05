package com.example.SpringBeginner.service;

import com.example.SpringBeginner.config.CustomUser;
import com.example.SpringBeginner.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("userservice")
public class UserService implements UserDetailsService {
    @Autowired
    CustomUser customUser;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        for(UserDTO userDTO : customUser.getUserDTOS()){
            if(userDTO.getUsername().equals(s)){

                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                for(String s1 : userDTO.getRole()){
                    grantedAuthorities.add(new SimpleGrantedAuthority(s1));
                }
                return new User(userDTO.getUsername(), userDTO.getPassword(),grantedAuthorities);
            }
        }
        return null;
    }
}
