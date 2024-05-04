package org.university.mongodb_airlines.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.university.mongodb_airlines.entity.Airline;
import org.university.mongodb_airlines.repository.AirlineRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public Airline createAirline(Airline airline) {
        if (!airlineRepository.existsByName(airline.getName())) {
            return airlineRepository.save(airline);
        }
        throw new IllegalArgumentException("Airline already exists");
    }

    public Airline getAirlineById(String id) {
        return airlineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airline not found"));
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline updateAirline(Airline airline) {
        if (airlineRepository.existsById(airline.getId())) {
            airlineRepository.save(airline);
        }
        throw new IllegalArgumentException("Airline not found");
    }

    public void deleteAirline(String id) {
        airlineRepository.deleteById(id);
    }
}
