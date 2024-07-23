package com.projet.FileManagement;

import com.projet.FileManagement.Repository.RoleRepository;
import com.projet.FileManagement.Repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class FileManagementApplication implements CommandLineRunner {

	private final RoleRepository roleRepository;
	private final UtilisateurRepository utilisateurRepository;
	private final PasswordEncoder passwordEncoder;

	public FileManagementApplication(RoleRepository roleRepository, UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
		this.roleRepository = roleRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public static void main(String[] args) {

		SpringApplication.run(FileManagementApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		if(roleRepository.findAll().size()==0){
			roleRepository.creationrole();
		}
		if(utilisateurRepository.findAll().size()==0){
			utilisateurRepository.createAdminAccount(passwordEncoder.encode("moussa1234"));
			utilisateurRepository.addRoleToAdmin();
		}
	}

}
