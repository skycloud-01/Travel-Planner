package com.example.demo.controller;

import com.example.demo.dto.TripDTO;
import com.example.demo.entity.Trip;
import com.example.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    TripService tripService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<TripDTO> getAllTrips(){return tripService.showAllTrips();}

    @GetMapping("/getById/{id}")
    @ResponseBody
    public TripDTO getTripById(@PathVariable Long id) {return tripService.showAllTripsById(id);}

    @PostMapping("/addTrip")
    @ResponseBody
    public TripDTO addTrip(@RequestBody Trip trip) { return tripService.addTrip(trip);}

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteTripById(@PathVariable Long id) {
        return tripService.deleteTripById(id);
    }

    @PutMapping("/updateTrip/{name}")
    @ResponseBody
    public TripDTO updateTrip(@RequestBody TripDTO tripDTO, @PathVariable String name){ return tripService.updateTrip(tripDTO, name);}
}
