package br.com.hackathon.easymed.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "questao")
@Getter
@Setter
public class Questao extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(generator = "questao_generator")
    @SequenceGenerator(
            name = "questao_generator",
            sequenceName = "questao_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ativo")
    private Boolean ativo;

}