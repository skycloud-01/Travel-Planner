package com.example.demo.controller;

import com.example.demo.dto.AgencyDTO;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.TripDTO;
import com.example.demo.entity.Agency;
import com.example.demo.entity.Client;
import com.example.demo.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencies")
public class AgencyController {
    @Autowired
    AgencyService agencyService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<AgencyDTO> getAllAgencies(){return agencyService.showAllAgencies();}

    @GetMapping("/getById/{id}")
    @ResponseBody
    public AgencyDTO getAgencyById(@PathVariable Long id) {return agencyService.showAllAgenciesById(id);}

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public String deleteAgencyById(@PathVariable Long id) {
        return agencyService.deleteAgencyById(id);
    }

    @PutMapping("/updateAgency/{name}")
    @ResponseBody
    public AgencyDTO updateAgency(@RequestBody Agency agency, @PathVariable String name){ return agencyService.updateAgency(agency, name);}

    @PostMapping("/addAgency")
    @ResponseBody
    public AgencyDTO addAgency(@RequestBody Agency agency) { return agencyService.addAgency(agency);}
}
