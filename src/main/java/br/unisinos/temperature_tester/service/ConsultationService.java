package br.unisinos.temperature_tester.service;

import br.unisinos.temperature_tester.domain.Consultation;
import br.unisinos.temperature_tester.repository.ConsultationRepository;
import br.unisinos.temperature_tester.repository.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final TreatmentRepository treatmentRepository;
    private final ConsultationRepository consultationRepository;

    public void registerConsultation(Consultation consultation, Long treatmentId) {
        var treatment = treatmentRepository.getTreatmentById(treatmentId);
        if (nonNull(treatment)){
            consultation.setTreatment(treatment);
            consultationRepository.save(consultation);
        }
    }
}
