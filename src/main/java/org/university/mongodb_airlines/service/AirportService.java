package org.university.mongodb_airlines.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.university.mongodb_airlines.entity.Airport;
import org.university.mongodb_airlines.repository.AirportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public Airport createAirport(Airport airport) {
        if(!airportRepository.existsByName(airport.getName())) {
            return airportRepository.save(airport);
        }
        throw new IllegalArgumentException("Airport already exists");
    }

    public Airport getAirportById(String id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found"));
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport updateAirport(Airport airport) {
        if(!airportRepository.existsById(airport.getId())) {
            throw new IllegalArgumentException("Airport not found");
        }
        return airportRepository.save(airport);
    }

    public void deleteAirport(String id) {
        airportRepository.deleteById(id);
    }
}
