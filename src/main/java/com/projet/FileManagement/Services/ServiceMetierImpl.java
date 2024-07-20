package com.projet.FileManagement.Services;

import com.projet.FileManagement.Repository.ServiceRepository;
import com.projet.FileManagement.models.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMetierImpl implements ServiceMetier {
    @Autowired
    private ServiceRepository serviceRepository;

    //Ajouter les services
    @Override
    public ServiceModel addService(ServiceModel serviceModel){
        return serviceRepository.save(serviceModel);
    }
    @Override
    public ServiceModel modifierService(Long id,ServiceModel newService){
        Optional<ServiceModel> serviceModelTrouve=serviceRepository.findById(id);
        if (serviceModelTrouve.isPresent())
        {
            ServiceModel serviceModel=serviceModelTrouve.get();
            serviceModel.setNomService(newService.getNomService());
            serviceModel.setDescription(newService.getDescription());
           return serviceRepository.save(serviceModel);
        }else {
            return null;
        }
    }
    // Supprimer le service
    @Override
    public void supprimerService(Long id){
        serviceRepository.deleteById(id);
    }
//Afficher la liste des Service
    @Override
    public List<ServiceModel> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceModel rechercherService(String nomService) {
        return serviceRepository.findBynomService(nomService);
    }
    //Afficher un service
    public ServiceModel getService(Long id){
      return serviceRepository.findById(id).orElse(null);
    }

   }
