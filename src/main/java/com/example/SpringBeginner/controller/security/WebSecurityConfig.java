package com.example.SpringBeginner.controller.security;

//import com.example.SpringBeginner.exception.RestAccessDeniedHandler;

import com.example.SpringBeginner.exception.RestAccessDeniedHandler;
import com.example.SpringBeginner.exception.RestAuthenticationEntryPoint;
import com.example.SpringBeginner.filter.JwtAuthenticationFilter;
import com.example.SpringBeginner.filter.JwtUsernamePasswordAuthenticationFilter;
import com.example.SpringBeginner.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //    @Qualifier("userservice")
//    @Autowired
//    UserDetailsService userDetailsService;
    @Qualifier("customUserDetailService")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JWTUtils jwtUtils;
    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    RestAccessDeniedHandler restAccessDeniedHandler;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Autowired
    RestAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtUtils),
                        BasicAuthenticationFilter.class)
                .addFilterAfter(jwtAuthenticationFilter, JwtUsernamePasswordAuthenticationFilter.class)
                .addFilter(new BasicAuthenticationFilter(authenticationManager()))
                .authorizeRequests()
                .antMatchers("/login", "/add").permitAll()
                .antMatchers("/book/find-all").hasAuthority("000")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .accessDeniedHandler(restAccessDeniedHandler)
        ;


                

        //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2FuZyIsImlhdCI6MTYwOTc4MzIxMiwiZXhwIjoxNjEwMzg4MDEyfQ.H9SXhYYrFz9WOBIe9dbfDASK8SwcRbRbC--u6U-go_o
        //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJob2FuZzEiLCJpYXQiOjE2MDk3ODMzMjUsImV4cCI6MTYxMDM4ODEyNX0.aYnwfUf6FZmQ4N8ufKlAUz7IQ3Yvw6qo4pYsLShMegU


    }
}
