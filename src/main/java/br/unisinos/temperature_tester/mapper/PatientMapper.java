package br.unisinos.temperature_tester.mapper;

import br.unisinos.temperature_tester.controller.request.PatientRequest;
import br.unisinos.temperature_tester.controller.response.PatientResponse;
import br.unisinos.temperature_tester.controller.response.TreatmentResponse;
import br.unisinos.temperature_tester.domain.Patient;
import br.unisinos.temperature_tester.domain.Treatment;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PatientMapper {

    public static Patient toDomain(PatientRequest request) {
        return Patient.builder()
                .name(request.getName())
                .birth(request.getBirth())
                .gender(request.getGender())
                .document(request.getDocument())
                .build();
    }

    public static PatientResponse toResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .document(patient.getDocument())
                .gender(patient.getGender())
                .birth(patient.getBirth())
                .treatments(getTreatments(patient.getTreatments()))
                .build();
    }

    public static List<PatientResponse> toResponse(List<Patient> patients) {
        var patientsResponse = new ArrayList<PatientResponse>();
        patients.forEach(patient -> patientsResponse.add(toResponse(patient)));
        return patientsResponse;
    }

    private static List<TreatmentResponse> getTreatments(List<Treatment> treatments) {
        var treatmentsResponse = new ArrayList<TreatmentResponse>();
        treatments.forEach(treatment -> treatmentsResponse.add(TreatmentMapper.toResponse(treatment)));
        return treatmentsResponse;
    }

}
