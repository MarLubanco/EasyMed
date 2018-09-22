package br.com.hackathon.easymed.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Consulta {

  @Id
  @GeneratedValue(generator = "consulta_generator")
  @SequenceGenerator(
          name = "consulta_generator",
          sequenceName = "consulta_sequence",
          initialValue = 100
  )
  private Long id;

  @Column
  private Date data;

  @Column
  private String observacao;

  @Column
  private String nomePaciente;

  @Column
  private String nomeMedico;

  @Column
  private String nomeClinica;

  @Column
  @OneToMany
  private List<Exame> exame;

  public Consulta(Long id, Date data, String observacao, String nomePaciente, String nomeMedico, String nomeClinica, List<Exame> exame) {
    this.id = id;
    this.data = data;
    this.observacao = observacao;
    this.nomePaciente = nomePaciente;
    this.nomeMedico = nomeMedico;
    this.nomeClinica = nomeClinica;
    this.exame = exame;
  }

  public Consulta() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public String getNomePaciente() {
    return nomePaciente;
  }

  public void setNomePaciente(String nomePaciente) {
    this.nomePaciente = nomePaciente;
  }

  public String getNomeMedico() {
    return nomeMedico;
  }

  public void setNomeMedico(String nomeMedico) {
    this.nomeMedico = nomeMedico;
  }

  public String getNomeClinica() {
    return nomeClinica;
  }

  public void setNomeClinica(String nomeClinica) {
    this.nomeClinica = nomeClinica;
  }

  public List<Exame> getExame() {
    return exame;
  }

  public void setExame(List<Exame> exame) {
    this.exame = exame;
  }
}
