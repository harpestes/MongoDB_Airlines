package org.university.mongodb_airlines.io;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.university.mongodb_airlines.entity.Airline;
import org.university.mongodb_airlines.io.payload.airline.CreateUpdateRequest;
import org.university.mongodb_airlines.service.AirlineService;

import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class AirlineCommands {

    private final AirlineService airlineService;

    @ShellMethod(value = "Create new airline", key = "airline create")
    public String createAirline() {
        CreateUpdateRequest createRequest = makeCreateUpdateRequest();

        Airline airline = Airline.builder()
                .name(createRequest.name())
                .description(createRequest.description())
                .email(createRequest.email())
                .hotlinePhoneNumber(createRequest.hotlinePhoneNumber())
                .build();

        return String.format("Airline with name %s created", airlineService.createAirline(airline).getName());
    }

    private CreateUpdateRequest makeCreateUpdateRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Airline Name: ");
        String airlineName = scanner.nextLine();
        System.out.println("Airline Description: ");
        String airlineDescription = scanner.nextLine();
        System.out.println("Airline Email: ");
        String airlineEmail = scanner.nextLine();
        System.out.println("Airline Hotline Phone Number: ");
        String airlineHotlinePhoneNumber = scanner.nextLine();

        return new CreateUpdateRequest(
                airlineName,
                airlineDescription,
                airlineEmail,
                airlineHotlinePhoneNumber
        );
    }

    @ShellMethod(value = "Show airline by ID", key = "airline show")
    public String getAirlineById(String id) {
        return TableCreator.createAirlineTable(List.of(airlineService.getAirlineById(id)));
    }

    @ShellMethod(value = "Show all airlines", key = "airline show all")
    public String getAllAirlines() {
        return TableCreator.createAirlineTable(airlineService.getAllAirlines());
    }

    @ShellMethod(value = "Update airline by ID", key = "airline update")
    public String updateAirlineById(String id) {
        Airline airline = airlineService.getAirlineById(id);
        CreateUpdateRequest updateRequest = makeCreateUpdateRequest();

        airline.setName(updateRequest.name());
        airline.setDescription(updateRequest.description());
        airline.setEmail(updateRequest.email());
        airline.setHotlinePhoneNumber(updateRequest.hotlinePhoneNumber());

        return String.format("Airline with name %s updated", airlineService.updateAirline(airline).getName());
    }

    @ShellMethod(value = "Delete airline by ID", key = "airline delete")
    public String deleteAirlineById(String id) {
        airlineService.deleteAirline(id);
        return String.format("Airline with ID %s deleted", id);
    }
}
