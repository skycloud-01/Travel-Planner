package com.example.demo.dto;

import java.util.List;

public class AgencyDTO {
    private String name;
    private String picture;
    private String description;
    private List<String> trips;

    public AgencyDTO(String name, String picture, String description, List<String> trips) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.trips = trips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTrips() {
        return trips;
    }

    public void setTrips(List<String> trips) {
        this.trips = trips;
    }
}
