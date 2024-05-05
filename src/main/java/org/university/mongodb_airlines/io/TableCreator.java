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
        table.addRule();
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
        table.addRule();
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
        table.addRule();
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
                "Plane Airline Name",
                "Borrowed Economy Seats Quantity",
                "Borrowed Business Seats Quantity",
                "Departure Airport Name",
                "Destination Airport Name",
                "Departure Date",
                "Departure Time",
                "Arrival Date",
                "Arrival Time"
        );
        table.addRule();
        for (Flight flight : flights) {
            table.addRow(
                    flight.getId(),
                    flight.getPlane().getAirline().getName(),
                    flight.getNumOfBorrowedEconomySeats(),
                    flight.getNumOfBorrowedBusinessSeats(),
                    flight.getDeparturePoint().getName(),
                    flight.getDestination().getName(),
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
        table.addRule();
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
        table.addRow("ID", "Client Name", "Flight Departure Date And Time", "Flight Arrival Date and Time");
        table.addRule();
        for (Ticket ticket : tickets) {
            table.addRow(
                    ticket.getId(),
                    ticket.getClient().getFullName(),
                    ticket.getFlight().getDepartureDate() + " " + ticket.getFlight().getDepartureTime(),
                    ticket.getFlight().getArrivalDate() + " " + ticket.getFlight().getArrivalTime()
            );
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());

        return table.render();
    }
}
