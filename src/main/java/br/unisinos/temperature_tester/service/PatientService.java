package br.unisinos.temperature_tester.service;

import br.unisinos.temperature_tester.domain.Patient;
import br.unisinos.temperature_tester.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public void registerPatient(Patient patient){
        var patientExists = consultPatient(patient.getDocument());
        if (isNull(patientExists)){
            patientRepository.save(patient);
        }
    }

    public Patient consultPatient(String document) {
        try{
            return patientRepository.getPatientByDocument(document);
        } catch (Exception e) {
            return null;
        }
    }
}
