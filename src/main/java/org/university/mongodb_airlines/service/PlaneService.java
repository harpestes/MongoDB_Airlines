package org.university.mongodb_airlines.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.university.mongodb_airlines.entity.Plane;
import org.university.mongodb_airlines.repository.PlaneRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public Plane createPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public Plane getPlaneById(String id) {
        return planeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plane not found"));
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public Plane updatePlane(Plane plane) {
        if (!planeRepository.existsById(plane.getId())) {
            throw new IllegalArgumentException("Plane not found!");
        }
        return planeRepository.save(plane);
    }

    public void deletePlane(String id) {
        planeRepository.deleteById(id);
    }
}
