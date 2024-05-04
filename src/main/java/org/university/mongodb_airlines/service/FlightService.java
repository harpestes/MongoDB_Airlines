package org.university.mongodb_airlines.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.university.mongodb_airlines.entity.Flight;
import org.university.mongodb_airlines.repository.FlightRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight getFlightById(String id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found!"));
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight updateFlight(Flight flight) {
        if (!flightRepository.existsById(flight.getId())) {
            throw new IllegalArgumentException("Flight not found!");
        }
        return flightRepository.save(flight);
    }

    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }
}
