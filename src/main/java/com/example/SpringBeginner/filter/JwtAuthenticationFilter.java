package com.example.SpringBeginner.filter;

import com.example.SpringBeginner.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JWTUtils jwtUtil;

    @Qualifier("customUserDetailService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {


            String authorizationString = httpServletRequest.getHeader("Authorization1");

        if (authorizationString != null && jwtUtil.validateToken(authorizationString)) {
            String username = jwtUtil.getUsernameFromToken(authorizationString);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
 //           httpServletRequest.getSession().setAttribute("userDetail", userDetails.getUsername());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null,
                    userDetails.getAuthorities());
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
