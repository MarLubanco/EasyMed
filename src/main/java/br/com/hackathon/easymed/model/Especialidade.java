package br.com.hackathon.easymed.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "especialidade")
@Getter
@Setter
public class Especialidade extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(generator = "especialidade_generator")
    @SequenceGenerator(
            name = "especialidade_generator",
            sequenceName = "especialidade_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "nome")
    private String nome;

}