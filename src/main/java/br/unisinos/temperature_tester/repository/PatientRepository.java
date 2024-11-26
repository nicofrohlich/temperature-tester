package br.unisinos.temperature_tester.repository;

import br.unisinos.temperature_tester.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient getPatientByDocument(String document);
}
