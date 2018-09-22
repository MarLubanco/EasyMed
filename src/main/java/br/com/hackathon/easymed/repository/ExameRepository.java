package br.com.hackathon.easymed.repository;

import br.com.hackathon.easymed.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExameRepository extends JpaRepository<Exame, Long> {

  Optional<Exame> findById(Long id);

}
