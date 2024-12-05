package br.unisinos.temperature_tester.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConsultationRequest {
    private Long treatmentId;
    private Long measuredTemperature;
}
