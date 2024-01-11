package org.apache.maven.archetypes.labxpertproject.repository;

import org.apache.maven.archetypes.labxpertproject.LabXpertProjectApplication;
import org.apache.maven.archetypes.labxpertproject.entitiy.enums.StatutDanalyse;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Analyse;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Echantillon;
import org.apache.maven.archetypes.labxpertproject.entitiy.model.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringJUnitConfig(LabXpertProjectApplication.class)
@SpringBootTest
class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AnalyseRepository analyseRepository;

    @Autowired
    EchantillonRepository echantillonRepository;

    Patient testPatient;
    Analyse testAnalyse;
    Echantillon testEchantillon;

        @BeforeEach
        void setUp() {
            testPatient = new Patient();
            testPatient.setNom("Test Patient");
            testPatient.setDateDeNaissance(LocalDate.of(1990, 1, 1));
            testPatient.setSexe("Male");
            testPatient.setAdresse("Test Address");
            testPatient.setTelephone("123456789");

            // Save the Patient entity first
            testPatient = patientRepository.save(testPatient);

            // Create an Analyse entity to associate with the Patient entity
            testAnalyse = new Analyse();
            testAnalyse.setDateDebutAnalyse(LocalDate.now());
            testAnalyse.setDateFinAnalyse(LocalDate.now().plusDays(7));
            testAnalyse.setEtatAnalyse(StatutDanalyse.EN_ATTENTE);
            testAnalyse.setCommentaire("Test Comment");
            testAnalyse.setPatient(testPatient);
            testAnalyse = analyseRepository.save(testAnalyse);

            // Create an Echantillon entity to associate with the Patient entity
            testEchantillon = new Echantillon();
            testEchantillon.setPatient(testPatient);
            testEchantillon = echantillonRepository.save(testEchantillon);

            // Save the Patient entity
            testPatient.getAnalyseHistory().add(testAnalyse);
            testPatient.getEchantillons().add(testEchantillon);
            testPatient = patientRepository.save(testPatient);
        }

    @Test
    void testCreatePatient() {
        Patient createdPatient = patientRepository.findById(testPatient.getPatientId()).orElse(null);

        assertThat(createdPatient).isNotNull();
        assertThat(createdPatient.getNom()).isEqualTo("Test Patient");
    }

    @Test
    void testUpdatePatient() {
        Patient existingPatient = patientRepository.findById(testPatient.getPatientId()).orElse(null);
        existingPatient.setNom("Updated Patient");

        patientRepository.save(existingPatient);

        Patient updatedPatient = patientRepository.findById(existingPatient.getPatientId()).orElse(null);

        assertThat(updatedPatient).isNotNull();
        assertThat(updatedPatient.getNom()).isEqualTo("Updated Patient");
    }

    @Test
    void testFindPatientById() {
        Patient foundPatient = patientRepository.findById(testPatient.getPatientId()).orElse(null);

        assertThat(foundPatient).isNotNull();
        assertThat(foundPatient.getNom()).isEqualTo("Test Patient");
    }

    @Test
    void testDeletePatient() {
        analyseRepository.deleteById(testAnalyse.getAnalyseId());
        echantillonRepository.deleteById(testEchantillon.getEchantillonId());
        patientRepository.deleteById(testPatient.getPatientId());

        Patient deletedPatient = patientRepository.findById(testPatient.getPatientId()).orElse(null);
        assertThat(deletedPatient).isNull();
    }

    @AfterEach
    void tearDown() {
        analyseRepository.deleteAll();
        echantillonRepository.deleteAll();
        patientRepository.deleteAll();
    }

}