package br.com.hackathon.easymed.model;

import javax.persistence.*;

@Entity
public class Exame {

  @Id
  @GeneratedValue(generator = "exame_generator")
  @SequenceGenerator(
          name = "exame_generator",
          sequenceName = "exame_sequence",
          initialValue = 100
  )
  private Long id;

  @Column
  private String tipo;

  public Exame(Long id, String tipo) {
    this.id = id;
    this.tipo = tipo;
  }

  public Exame() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
