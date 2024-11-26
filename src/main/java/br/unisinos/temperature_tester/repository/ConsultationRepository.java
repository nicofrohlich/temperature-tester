package br.unisinos.temperature_tester.repository;

import br.unisinos.temperature_tester.domain.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
