package br.com.hackathon.easymed.controller;

import br.com.hackathon.easymed.exception.ResourceNotFoundException;
import br.com.hackathon.easymed.model.Paciente;
import br.com.hackathon.easymed.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/paciente")
    public Page<Paciente> getQuestions(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }


    @PostMapping("/paciente")
    public Paciente createQuestion(@Valid @RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @PutMapping("/paciente/{pacienteId}")
    public Paciente updateQuestion(@PathVariable Long pacienteId,
                                   @Valid @RequestBody Paciente pacienteRequest) {
        return pacienteRepository.findById(pacienteId)
                .map(paciente -> {
                    paciente.setNome(pacienteRequest.getNome());
                    paciente.setNomeMae(pacienteRequest.getNomeMae());
                    return pacienteRepository.save(paciente);
                }).orElseThrow(() -> new ResourceNotFoundException("Paciênte não encontrado com id " + pacienteId));
    }


    @DeleteMapping("/paciente/{pacienteId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long pacienteId) {
        return pacienteRepository.findById(pacienteId)
                .map(paciente -> {
                    pacienteRepository.delete(paciente);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Paciênte não encontrado com id " + pacienteId));
    }
}