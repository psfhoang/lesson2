package com.example.SpringBeginner.config;

import com.example.SpringBeginner.dto.UserDTO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUser {
    List<UserDTO> userDTOS = new ArrayList<>();
    @PostConstruct
    public void init(){
        userDTOS.add(new UserDTO("hoang","$2y$12$fCvP6o3urfTItU8OYhTNz.u6Ojk6rHWKhqz0CZ/b09F.BnqZcHtq6",Roles.admin));
        userDTOS.add(new UserDTO("hoang1","$2y$12$fCvP6o3urfTItU8OYhTNz.u6Ojk6rHWKhqz0CZ/b09F.BnqZcHtq6",Roles.vip1));
    }

    public List<UserDTO> getUserDTOS() {
        return userDTOS;
    }

    public void setUserDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }
}
