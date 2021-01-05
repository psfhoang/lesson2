package com.example.SpringBeginner.service;

import com.example.SpringBeginner.dto.CustomUserDetail;
import com.example.SpringBeginner.dto.Register;
import com.example.SpringBeginner.entity.User;
import com.example.SpringBeginner.repository.RoleRepository;
import com.example.SpringBeginner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public CustomUserDetailService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(Register register){
        User user1= new User();
        user1.setUsername(register.getUsername());
        user1.setPassword(passwordEncoder.encode(register.getPassword()));
        user1.setRoles(roleRepository.findByName(register.getRole()));
        return userRepository.save(user1);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("user"+username+"not found"));
        System.out.println(user);
        UserDetails userDetails = new CustomUserDetail(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRoles().getAuthorities());

        return new org.springframework.security.core.userdetails.User(userDetails.getUsername(),userDetails.getPassword()
        ,userDetails.getAuthorities());

    }

}
