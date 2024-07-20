package com.projet.FileManagement.Controller;

import com.projet.FileManagement.Services.TicketServiceImp;
<<<<<<< HEAD
import com.projet.FileManagement.models.Role;
=======
>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
import com.projet.FileManagement.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:4200")
=======

>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
public class TicketController {
    @Autowired
    private TicketServiceImp ticketServiceImp;

    @PostMapping("/creer")
    public ResponseEntity<Ticket> createTicket(@RequestParam Long idUser, @RequestParam Long idService){
        Ticket ticket=ticketServiceImp.creerTicket(idUser,idService);
        return ResponseEntity.ok(ticket);
    }
    @PutMapping("/modifier")
    public ResponseEntity<Ticket> modifierTicket(@RequestParam Long id,@RequestParam Long idSer ,@RequestBody Ticket ticket){
        Ticket foundTicket=ticketServiceImp.modifierInfosTicket(id,ticket,idSer);
        return ResponseEntity.ok(foundTicket);
    }
    @DeleteMapping("/annuler/{idTicket}")
    public ResponseEntity<Void> annulerTicket(@PathVariable Long idTicket) {
        ticketServiceImp.annulerTicket(idTicket);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> toutlesTickets(){
        return ResponseEntity.ok(ticketServiceImp.getTickets());
    }
      @GetMapping("/position/{id}")
    public ResponseEntity<Integer> getPosition(@PathVariable Long id){
        return ResponseEntity.ok(ticketServiceImp.getPosition(id));
      }
<<<<<<< HEAD
    @GetMapping("/{idTicket}")
    public ResponseEntity<Ticket> afficherRole(@PathVariable Long idTicket) {
        Ticket ticket = ticketServiceImp.getTicket(idTicket);
        return ResponseEntity.ok(ticket);
    }
=======

>>>>>>> cf6b2c9e98c2aa77a4d3d76cbee550e733cb3aea
}
