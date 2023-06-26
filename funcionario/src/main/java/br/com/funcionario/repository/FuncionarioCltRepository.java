package br.com.funcionario.repository;

import br.com.funcionario.domain.Funcionario;
import br.com.funcionario.domain.FuncionarioClt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioCltRepository extends JpaRepository<FuncionarioClt, Long> {
    Optional<FuncionarioClt> findByFuncionario(Funcionario funcionario);
}
