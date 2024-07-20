package com.projet.FileManagement.Repository;

import com.projet.FileManagement.models.ServiceModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel,Long> {
    ServiceModel findBynomService(String nomService);
}