package org.apache.maven.archetypes.labxpertproject.repository;

import org.apache.maven.archetypes.labxpertproject.LabXpertProjectApplication;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDanalyse;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDeResultat;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Analyse;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Resultat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(LabXpertProjectApplication.class)
@SpringBootTest
class ResultatRepositoryTest {

    @Autowired
    ResultatRepository resultatRepository;

    @Autowired
    AnalyseRepository analyseRepository;

    Resultat testResultat;
    Analyse testAnalyse;

    @BeforeEach
    void setUp() {
        // Create an Analyse entity to associate with the Resultat entity
        testAnalyse = new Analyse();
        testAnalyse.setDateDebutAnalyse(LocalDate.now());
        testAnalyse.setDateFinAnalyse(LocalDate.now().plusDays(7));
        testAnalyse.setEtatAnalyse(StatutDanalyse.EN_ATTENTE);
        testAnalyse.setCommentaire("Test Comment");
        testAnalyse = analyseRepository.save(testAnalyse);

        // Create a Resultat entity to test
        testResultat = new Resultat();
        testResultat.setResultat("Test Result");
        testResultat.setUniteDeMesure("Test Unit");
        testResultat.setStatutDeResultat(StatutDeResultat.NORMAL);
        testResultat.setAnalyse(testAnalyse);
        testResultat = resultatRepository.save(testResultat);
    }

    @Test
    void testCreateResultat() {
        Resultat createdResultat = resultatRepository.findById(testResultat.getResultatId()).orElse(null);

        assertThat(createdResultat).isNotNull();
        assertThat(createdResultat.getResultat()).isEqualTo("Test Result");
    }

    @Test
    void testUpdateResultat() {
        Resultat existingResultat = resultatRepository.findById(testResultat.getResultatId()).orElse(null);
        existingResultat.setResultat("Updated Result");

        resultatRepository.save(existingResultat);

        Resultat updatedResultat = resultatRepository.findById(existingResultat.getResultatId()).orElse(null);

        assertThat(updatedResultat).isNotNull();
        assertThat(updatedResultat.getResultat()).isEqualTo("Updated Result");
    }

    @Test
    void testFindResultatById() {
        Resultat foundResultat = resultatRepository.findById(testResultat.getResultatId()).orElse(null);

        assertThat(foundResultat).isNotNull();
        assertThat(foundResultat.getResultat()).isEqualTo("Test Result");
    }

    @Test
    void testDeleteResultat() {
        resultatRepository.deleteById(testResultat.getResultatId());

        Resultat deletedResultat = resultatRepository.findById(testResultat.getResultatId()).orElse(null);
        assertThat(deletedResultat).isNull();
    }

    @AfterEach
    void tearDown() {

        resultatRepository.deleteAll();
        analyseRepository.deleteAll();

    }
}
