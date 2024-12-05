package br.unisinos.temperature_tester.service;

import br.unisinos.temperature_tester.domain.Patient;
import br.unisinos.temperature_tester.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient registerPatient(Patient patient){
        var existentPatient = consultPatient(patient.getDocument());
        if (isNull(existentPatient)) {
            return patientRepository.save(patient);
        }
        return existentPatient;
    }

    public Patient consultPatient(String document) {
        try{
            return patientRepository.getPatientByDocument(document);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Patient> listPatients(){
        return patientRepository.findAll();
    }
}
