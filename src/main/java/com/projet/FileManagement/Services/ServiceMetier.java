package com.projet.FileManagement.Services;

import com.projet.FileManagement.models.ServiceModel;

import java.util.List;

public interface ServiceMetier {
    ServiceModel addService(ServiceModel serviceModel);
    ServiceModel modifierService(Long id,ServiceModel newService);
    void supprimerService(Long id);
    List<ServiceModel> getAllService();
    ServiceModel rechercherService(String nomService);
    ServiceModel getService(Long idService);

}
