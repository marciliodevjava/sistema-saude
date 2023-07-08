package br.com.exames.repository;

import br.com.exames.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findByMedico(Long id);

    Endereco findByPaciente(Long id);
}
