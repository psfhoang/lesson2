package com.example.SpringBeginner.dto;

import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private List<String> role;

    public UserDTO(String username, String password, List<String> role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
