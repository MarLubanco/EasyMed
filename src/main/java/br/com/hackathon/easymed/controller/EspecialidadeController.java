package br.com.hackathon.easymed.controller;

import br.com.hackathon.easymed.model.Especialidade;
import br.com.hackathon.easymed.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @GetMapping("/especialidade")
    public Page<Especialidade> getEspecialidade(Pageable pageable) {
        return especialidadeRepository.findAll(pageable);
    }


    @PostMapping("/especialidade")
    public Especialidade createEspecialidade(@Valid @RequestBody Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }
}