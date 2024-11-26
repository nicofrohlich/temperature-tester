package br.unisinos.temperature_tester.repository;

import br.unisinos.temperature_tester.domain.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    Treatment getTreatmentById(Long id);
}
