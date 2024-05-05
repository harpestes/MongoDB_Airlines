package org.university.mongodb_airlines.io;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.university.mongodb_airlines.entity.Airport;
import org.university.mongodb_airlines.io.payload.airport.CreateUpdateRequest;
import org.university.mongodb_airlines.service.AirportService;

import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class AirportCommands {

    private final AirportService airportService;

    @ShellMethod(value = "Create new airport", key = "airport create")
    public String createAirport() {
        CreateUpdateRequest createRequest = makeCreateUpdateRequest();

        Airport airport = Airport.builder()
                .name(createRequest.name())
                .city(createRequest.city())
                .timeZone(createRequest.timeZone())
                .build();

        return String.format("Airport with name %s created", airportService.createAirport(airport).getName());
    }

    private CreateUpdateRequest makeCreateUpdateRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Airport Name: ");
        String airportName = scanner.nextLine();
        System.out.println("Airport City: ");
        String airportCity = scanner.nextLine();
        System.out.println("Airport Time Zone: ");
        String airportTimeZone = scanner.nextLine();

        return new CreateUpdateRequest(airportName, airportCity, airportTimeZone);
    }

    @ShellMethod(value = "Show airport by ID", key = "airport show")
    public String getAirportByID(String id) {
        return TableCreator.createAirportTable(List.of(airportService.getAirportById(id)));
    }

    @ShellMethod(value = "Show all airports", key = "airport show all")
    public String getAllAirports() {
        return TableCreator.createAirportTable(airportService.getAllAirports());
    }

    @ShellMethod(value = "Update airport by ID", key = "airport update")
    public String updateAirportByID(String id) {
        Airport airport = airportService.getAirportById(id);
        CreateUpdateRequest updateRequest = makeCreateUpdateRequest();

        airport.setName(updateRequest.name());
        airport.setCity(updateRequest.city());
        airport.setTimeZone(updateRequest.timeZone());

        return String.format("Airport with name %s updated", airportService.updateAirport(airport).getName());
    }

    @ShellMethod(value = "Delete airport by ID", key = "airport delete")
    public String deleteAirportByID(String id) {
        airportService.deleteAirport(id);
        return String.format("Airport with ID %s deleted", id);
    }
}
