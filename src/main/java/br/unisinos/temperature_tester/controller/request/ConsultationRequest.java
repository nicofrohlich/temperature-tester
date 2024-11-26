package br.unisinos.temperature_tester.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultationRequest {
    private Long treatmentId;
    private Long measuredTemperature;
}
