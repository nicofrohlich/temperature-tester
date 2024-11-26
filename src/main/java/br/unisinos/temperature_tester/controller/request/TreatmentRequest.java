package br.unisinos.temperature_tester.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreatmentRequest {
    private String patientDocument;
    private String treatmentRegion;
}
