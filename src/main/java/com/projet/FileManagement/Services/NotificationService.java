package com.projet.FileManagement.Services;

import com.projet.FileManagement.models.Notification;

import java.util.List;

public interface NotificationService {
    Notification creerNotification(Notification notification);
    void EnvoyerNotification(Long idTicket,Notification notification);
    List<Notification> getAllNotifications();
}
