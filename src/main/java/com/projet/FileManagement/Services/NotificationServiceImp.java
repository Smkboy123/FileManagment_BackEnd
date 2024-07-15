package com.projet.FileManagement.Services;

import com.projet.FileManagement.Repository.NotificationRepository;
import com.projet.FileManagement.Repository.TicketRepository;
import com.projet.FileManagement.models.Notification;
import com.projet.FileManagement.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImp implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Notification creerNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void EnvoyerNotification(Long idTicket, Notification notification) {
        Optional<Ticket> ticketOptional=ticketRepository.findById(idTicket);
        if (ticketOptional.isPresent()){
            Ticket ticket=ticketOptional.get();
            ticket.getNotifications().add(notification);
        }
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
