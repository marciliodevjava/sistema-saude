package br.com.funcionario.repository;

import br.com.funcionario.domain.FuncionarioClt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioCltRepository extends JpaRepository<FuncionarioClt, Long> {
}
