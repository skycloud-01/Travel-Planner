package com.example.demo.dto;

import java.util.List;

public class ClientDTO {
    private String username;
    private String picture;

    public ClientDTO(String username, String picture) {
        this.username = username;
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
