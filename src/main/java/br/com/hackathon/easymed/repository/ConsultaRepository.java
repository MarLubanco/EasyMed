package br.com.hackathon.easymed.repository;

import br.com.hackathon.easymed.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

  Optional<Consulta> findById(Long id);

}
