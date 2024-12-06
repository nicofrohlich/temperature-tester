package br.unisinos.temperature_tester.mapper;

import br.unisinos.temperature_tester.controller.request.TreatmentRequest;
import br.unisinos.temperature_tester.controller.response.ConsultationResponse;
import br.unisinos.temperature_tester.controller.response.TreatmentResponse;
import br.unisinos.temperature_tester.domain.Consultation;
import br.unisinos.temperature_tester.domain.Treatment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreatmentMapper {

    public static Treatment toDomain(TreatmentRequest request) {
        return Treatment.builder()
                .treatmentRegion(request.getTreatmentRegion())
                .initialDate(request.getInitialDate())
                .build();
    }

    public static TreatmentResponse toResponse(Treatment treatment) {
        return TreatmentResponse.builder()
                .id(treatment.getId())
                .treatmentRegion(treatment.getTreatmentRegion())
                .initialDate(treatment.getInitialDate())
                .consultations(nonNull(treatment.getConsultation()) ? getConsultations(treatment.getConsultation()) : null)
                .build();
    }

    private static List<ConsultationResponse> getConsultations(List<Consultation> consultations) {
        var consultationsResponse = new ArrayList<ConsultationResponse>();
        consultations.forEach(consultation -> consultationsResponse.add(ConsultationMapper.toResponse(consultation)));
        return consultationsResponse;
    }
}
