package org.university.mongodb_airlines.io;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.university.mongodb_airlines.entity.Client;
import org.university.mongodb_airlines.io.payload.client.CreateUpdateRequest;
import org.university.mongodb_airlines.service.ClientService;

import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ClientCommands {

    private final ClientService clientService;

    @ShellMethod(value = "Create new client", key = "client create")
    public String createClient() {
        CreateUpdateRequest createRequest = makeCreateUpdateRequest();

        Client client = Client.builder()
                .email(createRequest.email())
                .password(createRequest.password())
                .fullName(createRequest.fullName())
                .build();

        return String.format("Client with full name %s created", clientService.createClient(client).getFullName());
    }

    private CreateUpdateRequest makeCreateUpdateRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Client Email: ");
        String email = scanner.nextLine();
        System.out.println("Client Password: ");
        String password = scanner.nextLine();
        System.out.println("Client Full Name: ");
        String fullName = scanner.nextLine();

        return new CreateUpdateRequest(email, password, fullName);
    }

    @ShellMethod(value = "Show client by ID", key = "client show")
    public String getClientByID(String id) {
        return TableCreator.createClientTable(List.of(clientService.getClientById(id)));
    }

    @ShellMethod(value = "Show all clients", key = "client show all")
    public String getAllClients() {
        return TableCreator.createClientTable(clientService.getAllClients());
    }

    @ShellMethod(value = "Update client by ID", key = "client update")
    public String updateClientByID(String id) {
        Client client = clientService.getClientById(id);
        CreateUpdateRequest updateRequest = makeCreateUpdateRequest();

        client.setEmail(updateRequest.email());
        client.setPassword(updateRequest.password());
        client.setFullName(updateRequest.fullName());

        return String.format("Client with full name %s updated", clientService.updateClient(client).getFullName());
    }

    @ShellMethod(value = "Delete client by ID", key = "client delete")
    public String deleteClientByID(String id) {
        clientService.deleteClient(id);
        return String.format("Client with ID %s deleted", id);
    }
}
