package org.apache.maven.archetypes.labxpertproject;

import org.apache.maven.archetypes.labxpertproject.entitiy.enums.RoleDutilisateur;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Analyse;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Utilisateur;
import org.apache.maven.archetypes.labxpertproject.repository.AnalyseRepository;
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

    public static void main(String[] args) {
        SpringApplication.run(LabXpertProjectApplication.class, args);
    }

//
//    @Autowired
//    private AnalyseRepository analyseRepository;
//    @Autowired
//    private UtilisateurRepository u   tilisateurRepository;
//
//    @PostConstruct
//    public void init() {
//        Utilisateur user = new Utilisateur();
//        user.setNomUtilisateur("admin");
//        user.setEmail("hassanth@gmail.com");
//        user.setPassword("admin");
//        user.setRoleDutilisateur(RoleDutilisateur.ADMINISTRATEUR);
//        user.setInformationsPersonalises("Test user for testing");
//        utilisateurRepository.save(user);
//
//        Analyse analyse = new Analyse();
//        analyse.setCommentaire("Test Comment");
//        analyseRepository.save(analyse);
//
//
//    }

}
