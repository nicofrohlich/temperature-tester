package br.unisinos.temperature_tester.service;

import br.unisinos.temperature_tester.domain.Treatment;
import br.unisinos.temperature_tester.repository.PatientRepository;
import br.unisinos.temperature_tester.repository.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.*;

@Service
@RequiredArgsConstructor
public class TreatmentService {

    private final PatientRepository patientRepository;
    private final TreatmentRepository treatmentRepository;

    public Treatment registerTreatment(Treatment treatment, String document){
        var patient = patientRepository.getPatientByDocument(document);
        if (nonNull(patient)){
            treatment.setPatient(patient);
            return treatmentRepository.save(treatment);
        }
        return null;
    }
}
