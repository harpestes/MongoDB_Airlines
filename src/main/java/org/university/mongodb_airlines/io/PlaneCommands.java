package org.university.mongodb_airlines.io;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.university.mongodb_airlines.entity.Airline;
import org.university.mongodb_airlines.entity.Plane;
import org.university.mongodb_airlines.io.payload.plane.CreateUpdateRequest;
import org.university.mongodb_airlines.service.AirlineService;
import org.university.mongodb_airlines.service.PlaneService;

import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class PlaneCommands {

    private final PlaneService planeService;
    private final AirlineService airlineService;

    @ShellMethod(value = "Create new plane", key = "plane create")
    public String createPlane() {
        CreateUpdateRequest createRequest = makeCreateUpdateRequest();

        Plane plane = Plane.builder()
                .airline(createRequest.airline())
                .numOfEconomySeats(createRequest.numOfEconomySeats())
                .numOfBusinessSeats(createRequest.numOfBusinessSeats())
                .build();

        return String.format("Plane with ID %s created", planeService.createPlane(plane).getId());
    }

    private CreateUpdateRequest makeCreateUpdateRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Airline ID: ");
        String airlineId = scanner.nextLine();
        Airline airline = airlineService.getAirlineById(airlineId);
        System.out.println("Economy Seats Quantity: ");
        int numOfEconomySeats = scanner.nextInt();
        System.out.println("Business Seats Quantity: ");
        int numOfBusinessSeats = scanner.nextInt();

        return new CreateUpdateRequest(airline, numOfEconomySeats, numOfBusinessSeats);
    }

    @ShellMethod(value = "Show plane by ID", key = "plane show")
    public String getPlaneByID(String id) {
        return TableCreator.createPlaneTable(List.of(planeService.getPlaneById(id)));
    }

    @ShellMethod(value = "Show all planes", key = "plane show all")
    public String getAllPlanes() {
        return TableCreator.createPlaneTable(planeService.getAllPlanes());
    }

    @ShellMethod(value = "Update plane by ID", key = "plane update")
    public String updatePlaneByID(String id) {
        Plane plane = planeService.getPlaneById(id);
        CreateUpdateRequest updateRequest = makeCreateUpdateRequest();

        plane.setAirline(updateRequest.airline());
        plane.setNumOfEconomySeats(updateRequest.numOfEconomySeats());
        plane.setNumOfBusinessSeats(updateRequest.numOfBusinessSeats());

        return String.format("Plane with ID %s updated", planeService.updatePlane(plane).getId());
    }

    @ShellMethod(value = "Delete plane by ID", key = "plane delete")
    public String deletePlaneByID(String id) {
        planeService.deletePlane(id);
        return String.format("Plane with ID %s deleted", id);
    }
}
