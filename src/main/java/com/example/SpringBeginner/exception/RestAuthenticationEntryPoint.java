package com.example.SpringBeginner.exception;

import com.example.SpringBeginner.config.ErrorEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setStatus(ErrorEnum.UNAUTHORIZED.getCode());
        response.setContentType("application/json");
        ErrorDetails errorMessage = new ErrorDetails(ErrorEnum.UNAUTHORIZED.getCode(), ErrorEnum.UNAUTHORIZED.getMessage());
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, errorMessage);
        out.flush();

    }
}
