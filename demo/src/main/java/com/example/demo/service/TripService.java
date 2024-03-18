package com.example.demo.service;

import com.example.demo.dto.TripDTO;
import com.example.demo.entity.Trip;
import com.example.demo.repository.AgencyRepository;
import com.example.demo.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepository;
    @Autowired
    AgencyRepository agencyRepository;

    public List<TripDTO> showAllTrips(){
        return ((List<Trip>) tripRepository.findAll()).stream().map(trip -> new TripDTO(trip.getDestination(), trip.getAddress(), trip.getHotelName(), trip.getPrice(), trip.getStartDate(), trip.getEndDate(), trip.getDescription(), trip.getPhoto(), trip.getAgency().getName())).toList();
    }

    public TripDTO showAllTripsById(Long id){
        Optional<Trip> trip = tripRepository.findById(id);
        if(trip.isPresent()){
            return new TripDTO(trip.get().getDestination(), trip.get().getAddress(), trip.get().getHotelName(), trip.get().getPrice(), trip.get().getStartDate(), trip.get().getEndDate(), trip.get().getDescription(), trip.get().getPhoto(), trip.get().getAgency().getName());
        }else{
            return null;
        }
    }

    public TripDTO addTrip(Trip trip){
        if(tripRepository.findByAddress(trip.getAddress()).isEmpty()){
            Trip addedTrip = tripRepository.save(trip);
            return new TripDTO(addedTrip.getDestination(), addedTrip.getAddress(), addedTrip.getHotelName(), addedTrip.getPrice(), addedTrip.getStartDate(), addedTrip.getEndDate(), addedTrip.getDescription(), addedTrip.getPhoto(), addedTrip.getAgency().getName());
        }
        return null;
    }

    public String deleteTripById(long id){
        Optional<Trip> trip = tripRepository.findById(id);
        if(trip.isPresent()){
            tripRepository.deleteById(id);
            return "Trip deleted";
        }else {
            return "Trip not found";
        }
    }

    public TripDTO updateTrip(TripDTO tripDTO, String name){
        Optional<Trip> oldTrip = tripRepository.findByAddress(name);
        if(oldTrip.isPresent()){
            Trip trip = oldTrip.get();
            if(tripDTO.getDestination() != null){
                trip.setDestination(tripDTO.getDestination());
            }
            if(tripDTO.getAddress() != null){
                trip.setAddress(tripDTO.getAddress());
            }
            if(tripDTO.getHotelName() != null){
                trip.setHotelName(tripDTO.getHotelName());
            }
            if(tripDTO.getPrice() != null){
                trip.setPrice(tripDTO.getPrice());
            }
            if(tripDTO.getStartDate() != null){
                trip.setStartDate(tripDTO.getStartDate());
            }
            if(tripDTO.getEndDate() != null){
                trip.setEndDate(tripDTO.getEndDate());
            }
            if(tripDTO.getDescription() != null){
                trip.setDescription(tripDTO.getDescription());
            }
            if(tripDTO.getPhoto() != null){
                trip.setPhoto(tripDTO.getPhoto());
            }
            if(tripDTO.getAgency() != null){
                trip.setAgency(agencyRepository.findByName(tripDTO.getAgency()).get());
            }

            Trip newTrip = tripRepository.save(trip);
            return new TripDTO(newTrip.getDestination(), newTrip.getAddress(), newTrip.getHotelName(), newTrip.getPrice(), newTrip.getStartDate(), newTrip.getEndDate(), newTrip.getDestination(), newTrip.getPhoto(), newTrip.getAgency().getName());
        }
        return null;
    }
}
