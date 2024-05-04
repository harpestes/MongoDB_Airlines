package org.university.mongodb_airlines.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.university.mongodb_airlines.entity.Ticket;
import org.university.mongodb_airlines.repository.TicketRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(String id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket updateTicket(Ticket ticket) {
        if (!ticketRepository.existsById(ticket.getId())) {
            throw new IllegalArgumentException("Ticket not found");
        }
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(String id) {
        ticketRepository.deleteById(id);
    }
}
