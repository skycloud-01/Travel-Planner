package com.example.demo.service;

import com.example.demo.dto.AgencyDTO;
import com.example.demo.dto.TripDTO;
import com.example.demo.entity.Agency;
import com.example.demo.entity.Trip;
import com.example.demo.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {
    @Autowired
    AgencyRepository agencyRepository;

    public List<AgencyDTO> showAllAgencies(){
        return ((List<Agency>)agencyRepository.findAll()).stream().map(agency -> new AgencyDTO(agency.getName(), agency.getPicture(), agency.getDescription(), agency.getTrips().stream().map(Trip::getDestination).toList())).toList();
    }

    public AgencyDTO showAllAgenciesById(Long id){
        Optional<Agency> agency = agencyRepository.findById(id);
        if(agency.isPresent()){
            return new AgencyDTO(agency.get().getName(), agency.get().getPicture(), agency.get().getDescription(), agency.get().getTrips().stream().map(Trip::getAddress).toList());
        }else {
            return null;
        }
    }

    public AgencyDTO addAgency(Agency agency){
        if(agencyRepository.findByName(agency.getName()).isEmpty()){
            Agency insertedAgency = agencyRepository.save(agency);
            return new AgencyDTO(insertedAgency.getName(), insertedAgency.getPicture(), insertedAgency.getDescription(), insertedAgency.getTrips().stream().map(Trip::getAddress).toList());
        }
        return null;
    }

    public String deleteAgencyById(long id){
        Optional<Agency> agency = agencyRepository.findById(id);
        if(agency.isPresent()){
            agencyRepository.deleteById(id);
            return "Agency deleted";
        }else {
            return "Agency not found";
        }
    }

    public AgencyDTO updateAgency(Agency modifiedAgency, String name){
        Optional<Agency> oldAgency = agencyRepository.findByName(name);
        if(oldAgency.isPresent()){
            Agency agency = oldAgency.get();
            if(modifiedAgency.getEmail() != null){
                agency.setEmail(modifiedAgency.getEmail());
            }
            if(modifiedAgency.getPass() != null){
                agency.setPass(modifiedAgency.getPass());
            }
            if(modifiedAgency.getName() != null){
                agency.setName(modifiedAgency.getName());
            }
            if(modifiedAgency.getPicture() != null){
                agency.setPicture(modifiedAgency.getPicture());
            }
            if(modifiedAgency.getDescription() != null){
                agency.setDescription(modifiedAgency.getDescription());
            }

            Agency newAgency = agencyRepository.save(agency);
            return new AgencyDTO(newAgency.getName(), newAgency.getPicture(), newAgency.getDescription(), newAgency.getTrips().stream().map(Trip::getAddress).toList());
        }
        return null;
    }
}
