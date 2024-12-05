package br.unisinos.temperature_tester.mapper;

import br.unisinos.temperature_tester.controller.request.ConsultationRequest;
import br.unisinos.temperature_tester.controller.response.ConsultationResponse;
import br.unisinos.temperature_tester.domain.Consultation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsultationMapper {

    public static Consultation toDomain(ConsultationRequest request) {
        return Consultation.builder()
                .sessionDate(LocalDate.now())
                .temperatureValue(request.getMeasuredTemperature())
                .build();
    }

    public static ConsultationResponse toResponse(Consultation consultation) {
        return ConsultationResponse.builder()
                .id(consultation.getId())
                .sessionDate(consultation.getSessionDate())
                .temperatureValue(consultation.getTemperatureValue())
                .build();
    }

}
