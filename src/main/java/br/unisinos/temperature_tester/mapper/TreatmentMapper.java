package br.unisinos.temperature_tester.mapper;

import br.unisinos.temperature_tester.controller.response.ConsultationResponse;
import br.unisinos.temperature_tester.controller.response.TreatmentResponse;
import br.unisinos.temperature_tester.domain.Consultation;
import br.unisinos.temperature_tester.domain.Treatment;
import br.unisinos.temperature_tester.controller.request.TreatmentRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreatmentMapper {

    public static Treatment toDomain(TreatmentRequest request) {
        return Treatment.builder()
                .treatmentRegion(request.getTreatmentRegion())
                .initialDate(LocalDate.now())
                .build();
    }

    public static TreatmentResponse toResponse(Treatment treatment) {
        return TreatmentResponse.builder()
                .treatmentRegion(treatment.getTreatmentRegion())
                .initialDate(treatment.getInitialDate())
                .consultations(getConsultations(treatment.getConsultation()))
                .build();
    }

    private static List<ConsultationResponse> getConsultations(List<Consultation> consultations) {
        var consultationsResponse = new ArrayList<ConsultationResponse>();
        consultations.forEach(consultation -> consultationsResponse.add(ConsultationMapper.toResponse(consultation)));
        return consultationsResponse;
    }
}
