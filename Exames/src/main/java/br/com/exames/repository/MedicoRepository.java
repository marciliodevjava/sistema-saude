package br.com.exames.repository;

import br.com.exames.domain.Formulario;
import br.com.exames.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Optional<Medico> findByFormulario(Formulario formulario);

}
