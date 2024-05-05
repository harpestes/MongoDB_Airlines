package org.university.mongodb_airlines.io;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.university.mongodb_airlines.entity.Client;
import org.university.mongodb_airlines.entity.Flight;
import org.university.mongodb_airlines.entity.Ticket;
import org.university.mongodb_airlines.io.payload.ticket.CreateUpdateRequest;
import org.university.mongodb_airlines.service.ClientService;
import org.university.mongodb_airlines.service.FlightService;
import org.university.mongodb_airlines.service.TicketService;

import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class TicketCommands {

    private final TicketService ticketService;
    private final FlightService flightService;
    private final ClientService clientService;

    @ShellMethod(value = "Create new ticket", key = "ticket create")
    public String createPlane() {
        CreateUpdateRequest createRequest = makeCreateUpdateRequest();

        Ticket ticket = Ticket.builder()
                .client(createRequest.client())
                .flight(createRequest.flight())
                .build();

        return String.format("Ticket with ID %s created", ticketService.createTicket(ticket).getId());
    }

    private CreateUpdateRequest makeCreateUpdateRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Client ID: ");
        String clientId = scanner.nextLine();
        Client client = clientService.getClientById(clientId);
        System.out.println("Flight ID: ");
        String flightId = scanner.nextLine();
        Flight flight = flightService.getFlightById(flightId);

        return new CreateUpdateRequest(client, flight);
    }

    @ShellMethod(value = "Show ticket by ID", key = "ticket show")
    public String getTicketByID(String id) {
        return TableCreator.createTicketTable(List.of(ticketService.getTicketById(id)));
    }

    @ShellMethod(value = "Show all tickets", key = "ticket show all")
    public String getAllTickets() {
        return TableCreator.createTicketTable(ticketService.getAllTickets());
    }

    @ShellMethod(value = "Update ticket by ID", key = "ticket update")
    public String updateTicketByID(String id) {
        Ticket ticket = ticketService.getTicketById(id);
        CreateUpdateRequest updateRequest = makeCreateUpdateRequest();

        ticket.setClient(updateRequest.client());
        ticket.setFlight(updateRequest.flight());

        return String.format("Ticket with ID %s updated", ticketService.updateTicket(ticket).getId());
    }

    @ShellMethod(value = "Delete ticket by ID", key = "ticket delete")
    public String deleteTicketByID(String id) {
        ticketService.deleteTicket(id);
        return String.format("Ticket with ID %s deleted", id);
    }
}
