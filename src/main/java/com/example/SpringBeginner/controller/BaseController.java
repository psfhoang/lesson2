package com.example.SpringBeginner.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseController {
    public String userName;
    @ModelAttribute("BeforeRequest")
    public void beforeRequest(HttpServletRequest request, HttpServletResponse response){
        userName  = "PhamVietHoang";
        request.getSession().setAttribute("username",userName);
    }
}
