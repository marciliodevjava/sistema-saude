package br.com.exames.repository;

import br.com.exames.domain.Formulario;
import br.com.exames.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByFormulario(Formulario formulario);
}
