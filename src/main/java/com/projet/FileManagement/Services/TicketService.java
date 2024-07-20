package com.projet.FileManagement.Services;

import com.projet.FileManagement.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket creerTicket(Long idUser,Long idService);
    void annulerTicket(Long idTicket);
    int getPosition(Long idTicket);
    Ticket getTicket(Long idTicket);
    List<Ticket> getTickets();
    Ticket changerStatut(Long idTicket);
    Ticket modifierInfosTicket(Long idTicket, Ticket ticketDetails,Long idService);
}
