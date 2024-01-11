package org.apache.maven.archetypes.labxpertproject;

import org.apache.maven.archetypes.labxpertproject.entitiy.enums.RoleDutilisateur;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Utilisateur;
import org.apache.maven.archetypes.labxpertproject.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LabXpertProjectApplication {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public static void main(String[] args) {
        SpringApplication.run(LabXpertProjectApplication.class, args);
    }

}
