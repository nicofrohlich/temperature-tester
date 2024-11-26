package br.unisinos.temperature_tester.controller.response;

import br.unisinos.temperature_tester.domain.enums.GenderEnum;
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
    private String name;
    private LocalDate birth;
    private GenderEnum gender;
    private String document;
    private List<TreatmentResponse> treatments;
}
