package com.projet.FileManagement.Services;

import com.projet.FileManagement.Repository.FileAttenteRepository;
import com.projet.FileManagement.Repository.TicketRepository;
import com.projet.FileManagement.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TicketServiceImp implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ServiceMetier serviceMetier;
    @Autowired
    private  UtilisateurService utilisateurService;
    @Autowired
    private FileAttenteRepository fileAttenteRepository;
    //Création de Ticket
    @Override
    public Ticket creerTicket(Long idUser,Long idService){
        Ticket ticket = new Ticket();
        ticket.setStatus(StatutTicket.EN_COURS);
        Utilisateur utilisateur = utilisateurService.afficherCompte(idUser);
        ServiceModel serviceModel = serviceMetier.getService(idService);
        ticket.setUtilisateur(utilisateur);
        ticket.setServiceModel(serviceModel);

        FileAttente file = fileAttenteRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("File not found"));
        ticket.setFileAttente(file);

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket creerTicketSimple(String nom, String telephone, Long idService) {
        Ticket ticket = new Ticket();
        ServiceModel serviceModel = serviceMetier.getService(idService);
        ticket.setNom(nom);
        ticket.setTelephonne(telephone);
        ticket.setServiceModel(serviceModel);
        return ticketRepository.save(ticket);
    }

    @Override
    public void annulerTicket(Long idTicket) {
    ticketRepository.deleteById(idTicket);
    }

    @Override
    public int getPosition(Long idTicket) {
        Optional <Ticket> foundticket=ticketRepository.findById(idTicket);
        if (!foundticket.isPresent()) {
            return -1;
        }
            Ticket ticket = foundticket.get();
            List<Ticket> AllTicketService=ticketRepository.findByServiceModelOrderByHeurePriseAsc(ticket.getServiceModel());
            for (int i = 0; i < AllTicketService.size(); i++) {
                if (Objects.equals(AllTicketService.get(i).getIdTicket(), idTicket)) {
                    return i + 1; // Position 1-based
                }
            }
            return -1; // Si le ticket n'est pas trouvé (ce cas ne devrait pas se produire)

}
    @Override
    public Ticket getTicket(Long idTicket) {
        return ticketRepository.findById(idTicket).orElse(null);
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket changerStatut(Long idTicket) {
        Optional<Ticket> ticket=ticketRepository.findById(idTicket);
        if (ticket.isPresent()){
            Ticket newTicket=ticket.get();
            if ((newTicket.getStatus()==StatutTicket.EN_COURS)) {
                newTicket.setStatus(StatutTicket.SERVI);
                return ticketRepository.save(newTicket);
            }else{
                newTicket.setStatus(StatutTicket.EN_COURS);
                return ticketRepository.save(newTicket);
            }
        }

        return null;
    }

    @Override
    public Ticket modifierInfosTicket(Long idTicket,Ticket ticketDetails, Long idService) {
        Optional<Ticket> foundTicket=ticketRepository.findById(idTicket);
        if (foundTicket.isPresent()){
            Ticket ticket=foundTicket.get();
            ServiceModel serviceModel=serviceMetier.getService(idService);
            ticket.setServiceModel(serviceModel);
            ticket.setTelephonne(ticketDetails.getTelephonne());
            return ticketRepository.save(ticket);
        }

        return null;
    }
}
