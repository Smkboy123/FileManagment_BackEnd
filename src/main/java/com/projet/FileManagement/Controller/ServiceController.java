package com.projet.FileManagement.Controller;

import com.projet.FileManagement.Services.ServiceMetier;
import com.projet.FileManagement.models.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
    @Autowired
    private ServiceMetier serviceMetier;

    @PostMapping("/creer")
    public ResponseEntity<ServiceModel> createService(@RequestBody ServiceModel serviceModel){
        return ResponseEntity.ok(serviceMetier.addService(serviceModel));
    }
    @PutMapping("/modifier/{idService}")
    public ResponseEntity<ServiceModel> updateService(@PathVariable Long idService,@RequestBody ServiceModel serviceDetails){
        ServiceModel foundService=serviceMetier.modifierService(idService,serviceDetails);
        if (foundService!=null){
            return ResponseEntity.ok(foundService);
        }else {
            return  ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ServiceModel> supprimerService(@PathVariable Long id){
        serviceMetier.supprimerService(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<ServiceModel>> listesCompte(){
        List<ServiceModel> listes= serviceMetier.getAllService();
        return ResponseEntity.ok(listes);
    }

}










/*

@CrossOrigin(origins = "http://localhost:5173")

package com.projet.FileManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }
}

 /*
package com.projet.FileManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }
}
*/