package org.university.mongodb_airlines.io;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.university.mongodb_airlines.entity.Airport;
import org.university.mongodb_airlines.entity.Flight;
import org.university.mongodb_airlines.entity.Plane;
import org.university.mongodb_airlines.io.payload.flight.CreateUpdateRequest;
import org.university.mongodb_airlines.service.AirportService;
import org.university.mongodb_airlines.service.FlightService;
import org.university.mongodb_airlines.service.PlaneService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class FlightCommands {

    private final FlightService flightService;
    private final PlaneService planeService;
    private final AirportService airportService;

    @ShellMethod(value = "Create new flight", key = "flight create")
    public String createFlight() {
        CreateUpdateRequest createRequest = makeCreateUpdateRequest();

        Flight flight = Flight.builder()
                .plane(createRequest.plane())
                .numOfBorrowedEconomySeats(createRequest.numOfBorrowedEconomySeats())
                .numOfBorrowedBusinessSeats(createRequest.numOfBorrowedBusinessSeats())
                .departurePoint(createRequest.departurePoint())
                .destination(createRequest.destination())
                .departureDate(createRequest.departureDate())
                .departureTime(createRequest.departureTime())
                .arrivalDate(createRequest.arrivalDate())
                .arrivalTime(createRequest.arrivalTime())
                .build();

        return String.format("Flight with ID %s created", flightService.createFlight(flight).getId());
    }

    private CreateUpdateRequest makeCreateUpdateRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Flight Plane ID: ");
        String planeId = scanner.nextLine();
        Plane plane = planeService.getPlaneById(planeId);
        System.out.println("Borrowed Economy Seats Quantity: ");
        int borrowedEconomySeats = scanner.nextInt();
        System.out.println("Borrowed Business Seats Quantity: ");
        int borrowedBusinessSeats = scanner.nextInt();
        System.out.println("Departure Airport ID: ");
        scanner.nextLine();
        String departureAirportId = scanner.nextLine();
        Airport departure = airportService.getAirportById(departureAirportId);
        System.out.println("Destination Airport ID: ");
        String destinationAirportId = scanner.nextLine();
        Airport destination = airportService.getAirportById(destinationAirportId);
        System.out.println("Departure Date: ");
        String departureDate = scanner.nextLine();
        LocalDate departureFormatedDate = LocalDate.parse(departureDate);
        System.out.println("Departure Time: ");
        String departureTime = scanner.nextLine();
        LocalTime departureFormatedTime = LocalTime.parse(departureTime);
        System.out.println("Arrival Date: ");
        String arrivalDate = scanner.nextLine();
        LocalDate arrivalFormatedDate = LocalDate.parse(arrivalDate);
        System.out.println("Arrival Time: ");
        String arrivalTime = scanner.nextLine();
        LocalTime arrivalFormatedTime = LocalTime.parse(arrivalTime);

        return new CreateUpdateRequest(
                plane,
                borrowedEconomySeats,
                borrowedBusinessSeats,
                departure,
                destination,
                departureFormatedDate,
                departureFormatedTime,
                arrivalFormatedDate,
                arrivalFormatedTime
        );
    }

    @ShellMethod(value = "Show flight by ID", key = "flight show")
    public String getFlightByID(String id) {
        return TableCreator.createFlightTable(List.of(flightService.getFlightById(id)));
    }

    @ShellMethod(value = "Show all flights", key = "flight show all")
    public String getAllFlights() {
        return TableCreator.createFlightTable(flightService.getAllFlights());
    }

    @ShellMethod(value = "Update flight by ID", key = "flight update")
    public String updateFlightByID(String id) {
        Flight flight = flightService.getFlightById(id);
        CreateUpdateRequest updateRequest = makeCreateUpdateRequest();

        flight.setPlane(updateRequest.plane());
        flight.setNumOfBorrowedEconomySeats(updateRequest.numOfBorrowedEconomySeats());
        flight.setNumOfBorrowedBusinessSeats(updateRequest.numOfBorrowedBusinessSeats());
        flight.setDeparturePoint(updateRequest.departurePoint());
        flight.setDestination(updateRequest.destination());
        flight.setDepartureDate(updateRequest.departureDate());
        flight.setDepartureTime(updateRequest.departureTime());
        flight.setArrivalDate(updateRequest.arrivalDate());
        flight.setArrivalTime(updateRequest.arrivalTime());

        return String.format("Flight with ID %s updated", flightService.updateFlight(flight).getId());
    }

    @ShellMethod(value = "Delete flight by ID", key = "flight delete")
    public String deleteFlightByID(String id) {
        flightService.deleteFlight(id);
        return String.format("Flight with ID %s deleted", id);
    }
}
