package br.unisinos.temperature_tester.controller.request;

import br.unisinos.temperature_tester.domain.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientRequest {
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birth;
    private GenderEnum gender;
    private String document;
}
