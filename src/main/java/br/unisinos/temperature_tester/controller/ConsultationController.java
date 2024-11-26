package br.unisinos.temperature_tester.controller;

import br.unisinos.temperature_tester.controller.request.ConsultationRequest;
import br.unisinos.temperature_tester.mapper.ConsultationMapper;
import br.unisinos.temperature_tester.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping("/consultation")
public class ConsultationController {

    private final ConsultationService consultationService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void registerPatient(@RequestBody ConsultationRequest request){
        consultationService.registerConsultation(ConsultationMapper.toDomain(request), request.getTreatmentId());
    }

}
