package br.com.funcionario.repository;

import br.com.funcionario.domain.FuncionarioClt;
import br.com.funcionario.domain.FuncionarioCnpj;
import br.com.funcionario.domain.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long> {
    Optional<Salario> findByFuncionarioClt(FuncionarioClt funcionarioClt);

    Optional<Salario> findByFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj);
}
