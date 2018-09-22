package br.com.hackathon.easymed.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "paciente")
@Getter
@Setter
public class Paciente extends Pessoa implements Serializable {
    @Id
    @GeneratedValue(generator = "paciente_generator")
    @SequenceGenerator(
            name = "paciente_generator",
            sequenceName = "paciente_sequence",
            initialValue = 1000
    )
    private Long id;
}
