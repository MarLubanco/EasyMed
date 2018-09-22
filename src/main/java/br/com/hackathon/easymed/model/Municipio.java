package br.com.hackathon.easymed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "municipio")
@Getter
@Setter
public class Municipio extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(generator = "municipio_generator")
    @SequenceGenerator(
            name = "municipio_generator",
            sequenceName = "municipio_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "nome")
    private String nome;


   @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estado_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Estado estado;
}
