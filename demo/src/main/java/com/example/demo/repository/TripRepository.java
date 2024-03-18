package com.example.demo.repository;

import com.example.demo.entity.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
    Optional<Trip> findByAddress(String address);
}
