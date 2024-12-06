package br.unisinos.temperature_tester.controller;

import br.unisinos.temperature_tester.controller.request.PatientRequest;
import br.unisinos.temperature_tester.controller.response.PatientResponse;
import br.unisinos.temperature_tester.mapper.PatientMapper;
import br.unisinos.temperature_tester.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.unisinos.temperature_tester.mapper.PatientMapper.toDomain;
import static br.unisinos.temperature_tester.mapper.PatientMapper.toResponse;
import static java.util.Objects.isNull;

@Controller
@RequiredArgsConstructor
@RequestMapping(produces = "application/json")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/patient")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<PatientResponse> registerPatient(@RequestBody PatientRequest request){
        var patient = patientService.registerPatient(toDomain(request));
        return isNull(patient) ? ResponseEntity.badRequest().build() : ResponseEntity.ok().body(PatientMapper.toResponse(patient));
    }

    @GetMapping("/patient/{document}")
    public ResponseEntity<PatientResponse> consultPatient(@PathVariable String document){
        var patient = patientService.consultPatient(document);
        return isNull(patient) ? ResponseEntity.notFound().build() : ResponseEntity.ok(toResponse(patient));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponse>> listPatients(){
        var patients = patientService.listPatients();
        return isNull(patients) ? ResponseEntity.noContent().build() : ResponseEntity.ok(toResponse(patients));
    }

}
