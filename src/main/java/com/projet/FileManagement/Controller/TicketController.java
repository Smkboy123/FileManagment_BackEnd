package com.projet.FileManagement.Controller;

import com.projet.FileManagement.Exception.ApiConstants;
import com.projet.FileManagement.Services.TicketServiceImp;
import com.projet.FileManagement.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_VERSION_ONE + "ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    @Autowired
    private TicketServiceImp ticketServiceImp;

    @PostMapping("/creer")
    public ResponseEntity<Ticket> createTicket(@RequestParam Long idUser,
                                               @RequestParam Long idService){
        Ticket ticket=ticketServiceImp.creerTicket(idUser,idService);
        return ResponseEntity.ok(ticket);
    }
    @PostMapping("/creerSimple")
    public ResponseEntity<Ticket> creerUnTicket_Sans_seConnecter(@RequestParam String nom,
                                                                 @RequestParam String telephone,
                                                                 @RequestParam Long idService){
        Ticket ticket=ticketServiceImp.creerTicketSimple(nom,telephone,idService);
        return ResponseEntity.ok(ticket);
    }
    @PutMapping("/modifier")
    public ResponseEntity<Ticket> modifierTicket(@RequestParam Long id,
                                                 @RequestParam Long idSer ,
                                                 @RequestBody Ticket ticket){
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
    @GetMapping("/{idTicket}")
    public ResponseEntity<Ticket> afficherRole(@PathVariable Long idTicket) {
        Ticket ticket = ticketServiceImp.getTicket(idTicket);
        return ResponseEntity.ok(ticket);
    }
}
