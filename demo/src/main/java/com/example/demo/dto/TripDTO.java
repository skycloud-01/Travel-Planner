package com.example.demo.dto;

import com.example.demo.entity.Agency;
import com.example.demo.entity.Trip;

public class TripDTO {
    private String destination;
    private String address;
    private String hotelName;
    private String price;
    private String startDate;
    private String endDate;
    private String description;
    private String photo;
    private String agency;

    public TripDTO(){

    }

    public TripDTO(String destination, String address, String hotelName, String price, String startDate, String endDate, String description, String photo, String agency) {
        this.destination = destination;
        this.address = address;
        this.hotelName = hotelName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.photo = photo;
        this.agency = agency;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photos) {
        this.photo = photos;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void replaceNullFields(TripDTO tripDTO){
        if(this.destination == null){
            this.destination = tripDTO.getDestination();
        }
        if(this.address == null){
            this.address = tripDTO.getAddress();
        }
        if(this.hotelName == null){
            this.hotelName = tripDTO.getHotelName();
        }
        if(this.price == null) {
            this.price = tripDTO.getPrice();
        }
        if(this.startDate == null){
            this.startDate = tripDTO.getStartDate();
        }
        if(this.endDate == null){
            this.endDate = tripDTO.getEndDate();
        }
        if(this.description == null){
            this.description = tripDTO.getDescription();
        }
        if(this.photo == null){
            this.photo = tripDTO.getPhoto();
        }
        if(this.agency == null){
            this.agency = tripDTO.getAgency();
        }
    }
}
