package br.com.hackathon.easymed.controller;

import br.com.hackathon.easymed.model.Exame;
import br.com.hackathon.easymed.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exames")
public class ExameContoler {

  @Autowired
  private ExameRepository exameRepository;

  @GetMapping("/{id}")
  public Optional<Exame> getConsulta(@PathVariable("id") Long id) {
    return exameRepository.findById(id);
  }

  @GetMapping
  public List<Exame> getAll() {
    return exameRepository.findAll();
  }

  @PostMapping
  public Exame save(@RequestBody Exame exame) {
    return exameRepository.save(exame);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    exameRepository.deleteById(id);
  }
}
