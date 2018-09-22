package br.com.hackathon.easymed.repository;

import br.com.hackathon.easymed.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

    Optional<Clinica> findById(Long id);

}
