package br.com.funcionario.repository;

import br.com.funcionario.domain.AuxilioAlimentacao;
import br.com.funcionario.domain.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuxilioAlimentacaoRepository extends JpaRepository<AuxilioAlimentacao, Long> {
    Optional<AuxilioAlimentacao> findBySalario(Salario salario);
}
