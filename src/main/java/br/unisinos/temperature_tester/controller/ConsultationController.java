package br.unisinos.temperature_tester.controller;

import br.unisinos.temperature_tester.controller.request.ConsultationRequest;
import br.unisinos.temperature_tester.controller.response.ConsultationResponse;
import br.unisinos.temperature_tester.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static br.unisinos.temperature_tester.mapper.ConsultationMapper.toDomain;
import static br.unisinos.temperature_tester.mapper.ConsultationMapper.toResponse;
import static java.util.Objects.isNull;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultation")
public class ConsultationController {

    private final ConsultationService consultationService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ConsultationResponse> registerPatient(@RequestBody ConsultationRequest request){
        var consultation = consultationService.registerConsultation(toDomain(request), request.getTreatmentId());
        return isNull(consultation) ? ResponseEntity.badRequest().build() : ResponseEntity.ok().body(toResponse(consultation));
    }

}
