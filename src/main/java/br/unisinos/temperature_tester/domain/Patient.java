package br.unisinos.temperature_tester.domain;

import br.unisinos.temperature_tester.domain.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private LocalDate birth;
    @Column(unique = true)
    private String document;
    private GenderEnum gender;
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<Treatment> treatments = new ArrayList<>();
}
