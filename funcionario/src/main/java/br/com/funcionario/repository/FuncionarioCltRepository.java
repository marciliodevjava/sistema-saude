package br.com.funcionario.repository;

import br.com.funcionario.domain.FuncionarioClt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioCltRepository extends JpaRepository<FuncionarioClt, Long> {
}
