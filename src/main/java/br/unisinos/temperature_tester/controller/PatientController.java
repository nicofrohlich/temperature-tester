package br.unisinos.temperature_tester.controller;

import br.unisinos.temperature_tester.controller.request.PatientRequest;
import br.unisinos.temperature_tester.controller.response.PatientResponse;
import br.unisinos.temperature_tester.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static br.unisinos.temperature_tester.mapper.PatientMapper.toDomain;
import static br.unisinos.temperature_tester.mapper.PatientMapper.toResponse;
import static java.util.Objects.isNull;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/patient", produces = "application/json")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void registerPatient(@RequestBody PatientRequest request){
        patientService.registerPatient(toDomain(request));
    }

    @GetMapping("{document}")
    public ResponseEntity<PatientResponse> consultPatient(@PathVariable String document){
        var patient = patientService.consultPatient(document);
        return isNull(patient) ? ResponseEntity.notFound().build() : ResponseEntity.ok(toResponse(patient));
    }

}
