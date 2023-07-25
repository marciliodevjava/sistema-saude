package br.com.exames.repository;

import br.com.exames.domain.Endereco;
import br.com.exames.domain.Medico;
import br.com.exames.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByMedico(Medico medico);

    Optional<Endereco> findByPaciente(Paciente paciente);
}
