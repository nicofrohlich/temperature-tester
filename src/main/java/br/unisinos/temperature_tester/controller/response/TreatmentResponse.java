package br.unisinos.temperature_tester.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreatmentResponse {
    private String treatmentRegion;
    private LocalDate initialDate;
    private List<ConsultationResponse> consultations;
}
