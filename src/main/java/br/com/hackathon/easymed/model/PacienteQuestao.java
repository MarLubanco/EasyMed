package br.com.hackathon.easymed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "paciente_questao")
@Getter
@Setter
public class PacienteQuestao extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(generator = "paciente_questao_generator")
    @SequenceGenerator(
            name = "paciente_questao_generator",
            sequenceName = "paciente_questao_sequence",
            initialValue = 1000
    )
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnore
    private Paciente paciente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questao_id")
    @JsonIgnore
    private Questao questao;

    @Column(name = "resposta")
    private Boolean resposta;

    @Column(name = "observacao")
    private String observacao;
}
