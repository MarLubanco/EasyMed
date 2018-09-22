package br.com.hackathon.easymed.controller;

import br.com.hackathon.easymed.exception.ResourceNotFoundException;
import br.com.hackathon.easymed.model.Medico;
import br.com.hackathon.easymed.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/medico")
    public Page<Medico> getMedico(Pageable pageable) {
        return medicoRepository.findAll(pageable);
    }


    @PostMapping("/medico")
    public Medico createMedico(@Valid @RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    @PutMapping("/medico/{pacienteId}")
    public Medico updateMedico(@PathVariable Long pacienteId,
                                   @Valid @RequestBody Medico pacienteRequest) {
        return medicoRepository.findById(pacienteId)
                .map(medico -> {
                    medico.setNome(pacienteRequest.getNome());
                    medico.setNomeMae(pacienteRequest.getNomeMae());
                    return medicoRepository.save(medico);
                }).orElseThrow(() -> new ResourceNotFoundException("Paciênte não encontrado com id " + pacienteId));
    }


    @DeleteMapping("/medico/{pacienteId}")
    public ResponseEntity<?> deleteMedico(@PathVariable Long pacienteId) {
        return medicoRepository.findById(pacienteId)
                .map(medico -> {
                    medicoRepository.delete(medico);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Paciênte não encontrado com id " + pacienteId));
    }
}