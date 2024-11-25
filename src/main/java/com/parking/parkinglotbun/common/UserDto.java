package com.parking.parkinglotbun.common;

public class UserDto {
    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    String username;
    String email;

}
