package br.com.hackathon.easymed.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estado")
@Getter
@Setter
public class Estado extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(generator = "estado_generator")
    @SequenceGenerator(
            name = "estado_generator",
            sequenceName = "estado_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla")
    private String sigla;

}
