package com.parking.parkinglotbun.common;

public class UserDto {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public UserDto(Long id,String username, String email) {
        this.username = username;
        this.email = email;
        this.id=id;
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
