package br.com.hackathon.easymed.model;

import javax.persistence.*;

@Entity
public class Clinica {

  @Id
  @GeneratedValue(generator = "clinica_generator")
  @SequenceGenerator(
          name = "clinica_generator",
          sequenceName = "clinica_sequence",
          initialValue = 100
  )
  private Long id;

  @Column
  private String CNPJ;

  @Column
  private String endereco;

  @Column
  private String razaoSocial;

  @Column
  private String nome;

  @Column
  private String especializacao;

  public Clinica(Long id, String CNPJ, String endereco, String razaoSocial, String nome, String especializacao) {
    this.id = id;
    this.CNPJ = CNPJ;
    this.endereco = endereco;
    this.razaoSocial = razaoSocial;
    this.nome = nome;
    this.especializacao = especializacao;
  }

  public Clinica() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCNPJ() {
    return CNPJ;
  }

  public void setCNPJ(String CNPJ) {
    this.CNPJ = CNPJ;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEspecializacao() {
    return especializacao;
  }

  public void setEspecializacao(String especializacao) {
    this.especializacao = especializacao;
  }
}
