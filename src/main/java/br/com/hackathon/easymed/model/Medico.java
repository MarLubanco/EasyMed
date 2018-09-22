package br.com.hackathon.easymed.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "medico")
@Getter
@Setter
public class Medico extends Pessoa implements Serializable {
    @Id
    @GeneratedValue(generator = "medico_generator")
    @SequenceGenerator(
            name = "medico_generator",
            sequenceName = "medico_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "crm")
    private String crm;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "medico_especialidade",
            joinColumns = {@JoinColumn(name = "especialidade_id")},
            inverseJoinColumns = {@JoinColumn(name = "medico_id")})
    private List<Especialidade> especialidades;
}
