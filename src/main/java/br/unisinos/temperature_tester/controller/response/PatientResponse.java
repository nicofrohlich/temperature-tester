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
public class PatientResponse {
    private Long id;
    private String name;
    private LocalDate birth;
    private String gender;
    private String document;
    private List<TreatmentResponse> treatments;
}
