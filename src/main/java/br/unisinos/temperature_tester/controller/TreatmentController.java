package br.unisinos.temperature_tester.controller;

import br.unisinos.temperature_tester.controller.request.TreatmentRequest;
import br.unisinos.temperature_tester.controller.response.TreatmentResponse;
import br.unisinos.temperature_tester.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static br.unisinos.temperature_tester.mapper.TreatmentMapper.toDomain;
import static br.unisinos.temperature_tester.mapper.TreatmentMapper.toResponse;
import static java.util.Objects.isNull;

@Controller
@RequestMapping(value = "/treatment", produces = "application/json")
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentService treatmentService;

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<TreatmentResponse> registerTreatment(@RequestBody TreatmentRequest request) {
        var treatment = treatmentService.registerTreatment(toDomain(request), request.getPatientDocument());
        return isNull(treatment) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(toResponse(treatment));
    }

}
