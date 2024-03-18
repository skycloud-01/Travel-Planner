package com.example.demo.repository;

import com.example.demo.entity.Agency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long> {
    Optional<Agency> findByName(String name);
}
