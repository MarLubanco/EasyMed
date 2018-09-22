package br.com.hackathon.easymed.controller;

import br.com.hackathon.easymed.model.Clinica;
import br.com.hackathon.easymed.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinicas")
public class ClinicaService {

  @Autowired
  private ClinicaRepository clinicaRepository;

  @GetMapping("/{id}")
  public Optional<Clinica> getClinica(@PathVariable("id") Long id) {
    return clinicaRepository.findById(id);
  }

  @GetMapping
  public List<Clinica> getAll() {
    return clinicaRepository.findAll();
  }

  @PostMapping
  public Clinica save(@RequestBody Clinica clinica) {
    return clinicaRepository.save(clinica);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    clinicaRepository.deleteById(id);
  }
}
