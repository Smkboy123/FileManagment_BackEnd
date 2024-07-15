package com.projet.FileManagement.Controller;

import com.projet.FileManagement.Services.NotificationService;
import com.projet.FileManagement.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/creer")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
        return ResponseEntity.ok(notificationService.creerNotification(notification));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Notification>> getAllNotification(){
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }
    @PostMapping("/envoie")
    public ResponseEntity<Void> sendNotification(@RequestParam Long idTicket, @RequestBody Notification notification){
        notificationService.EnvoyerNotification(idTicket,notification);
        return ResponseEntity.ok().build();
    }
}
