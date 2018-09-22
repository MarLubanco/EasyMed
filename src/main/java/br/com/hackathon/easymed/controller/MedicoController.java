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

    @PutMapping("/medico/{medicoId}")
    public Medico updateMedico(@PathVariable Long medicoId,
                                   @Valid @RequestBody Medico medicoRequest) {
        return medicoRepository.findById(medicoId)
                .map(medico -> {
                    medico.setNome(medicoRequest.getNome());
                    medico.setNomeMae(medicoRequest.getNomeMae());
                    return medicoRepository.save(medico);
                }).orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com id " + medicoId));
    }


    @DeleteMapping("/medico/{medicoId}")
    public ResponseEntity<?> deleteMedico(@PathVariable Long medicoId) {
        return medicoRepository.findById(medicoId)
                .map(medico -> {
                    medicoRepository.delete(medico);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado com id " + medicoId));
    }
}