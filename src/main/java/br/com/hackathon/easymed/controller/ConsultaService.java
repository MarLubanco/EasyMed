package br.com.hackathon.easymed.controller;

import br.com.hackathon.easymed.model.Consulta;
import br.com.hackathon.easymed.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaService {

  @Autowired
  private ConsultaRepository consultaRepository;

  @GetMapping("/{id}")
  public Optional<Consulta> getConsulta(@PathVariable("id") Long id) {
    return consultaRepository.findById(id);
  }

  @GetMapping
  public List<Consulta> getAll() {
    return consultaRepository.findAll();
  }

  @PostMapping
  public Consulta save(@RequestBody Consulta consulta) {
    return consultaRepository.save(consulta);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    consultaRepository.deleteById(id);
  }
}
