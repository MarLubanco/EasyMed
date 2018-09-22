package br.com.hackathon.easymed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paciente")
@Getter
@Setter
public class Paciente extends AuditModel {
    @Id
    @GeneratedValue(generator = "paciente_generator")
    @SequenceGenerator(
            name = "paciente_generator",
            sequenceName = "paciente_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "cpf")
    private Integer cpf;

    @Column(name = "rg")
    private Integer rg;

    @Column(name = "celular")
    private String celular;

    @Column(name = "telefoneResidencial")
    private String telefoneResidencial;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    @JsonIgnore
    private Endereco endereco;
}
