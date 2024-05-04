package org.university.mongodb_airlines.io;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import org.university.mongodb_airlines.entity.*;

import java.util.List;

public class TableCreator {

    static String createAirlineTable(List<Airline> airlines) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID", "Name", "Description", "Email", "Hotline phone number");
        for (Airline airline : airlines) {
            table.addRow(
                    airline.getId(),
                    airline.getName(),
                    airline.getDescription(),
                    airline.getEmail(),
                    airline.getHotlinePhoneNumber()
            );
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());

        return table.render();
    }

    static String createAirportTable(List<Airport> airports) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID", "Name", "City", "Time Zone");
        for (Airport airport : airports) {
            table.addRow(
                    airport.getId(),
                    airport.getName(),
                    airport.getCity(),
                    airport.getTimeZone()
            );
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());

        return table.render();
    }

    static String createClientTable(List<Client> clients) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID", "Email", "Password", "Full Name");
        for (Client client : clients) {
            table.addRow(
                    client.getId(),
                    client.getEmail(),
                    client.getPassword(),
                    client.getFullName()
            );
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());

        return table.render();
    }

    static String createFlightTable(List<Flight> flights) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(
                "ID",
                "Plane ID",
                "Borrowed Economy Seats Quantity",
                "Borrowed Business Seats Quantity",
                "Departure Airport ID",
                "Destination Airport ID",
                "Departure Date",
                "Departure Time",
                "Arrival Date",
                "Arrival Time"
        );
        for (Flight flight : flights) {
            table.addRow(
                    flight.getId(),
                    flight.getPlane().getId(),
                    flight.getNumOfBorrowedEconomySeats(),
                    flight.getNumOfBorrowedBusinessSeats(),
                    flight.getDeparturePoint().getId(),
                    flight.getDestination().getId(),
                    flight.getDepartureDate(),
                    flight.getDepartureTime(),
                    flight.getArrivalDate(),
                    flight.getArrivalTime()
            );
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());

        return table.render();
    }

    static String createPlaneTable(List<Plane> planes) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID", "Airline Name", "Economy Seats Quantity", "Business Seats Quantity");
        for (Plane plane : planes) {
            table.addRow(
                    plane.getId(),
                    plane.getAirline().getName(),
                    plane.getNumOfEconomySeats(),
                    plane.getNumOfBusinessSeats()
            );
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());

        return table.render();
    }

    static String createTicketTable(List<Ticket> tickets) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("ID", "Client ID", "Flight ID");
        for (Ticket ticket : tickets) {
            table.addRow(
                    ticket.getId(),
                    ticket.getClient().getId(),
                    ticket.getFlight().getId()
            );
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());

        return table.render();
    }
}
