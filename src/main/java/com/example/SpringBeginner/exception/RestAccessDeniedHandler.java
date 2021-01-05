package com.example.SpringBeginner.exception;

import com.example.SpringBeginner.config.ErrorEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(ErrorEnum.FORBIDDEN.getCode());
        response.setContentType("application/json");
        ErrorDetails errorDetails = new ErrorDetails(ErrorEnum.FORBIDDEN.getCode(),
                ErrorEnum.FORBIDDEN.getMessage());
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream,errorDetails);
        outputStream.flush();

    }
}
