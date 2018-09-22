package br.com.hackathon.easymed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
public class Endereco extends AuditModel {
    @Id
    @GeneratedValue(generator = "endereco_generator")
    @SequenceGenerator(
            name = "endereco_generator",
            sequenceName = "endereco_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep")
    private String cep;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "municipio_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Municipio municipio;
}
