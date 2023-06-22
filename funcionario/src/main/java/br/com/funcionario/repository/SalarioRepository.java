package br.com.funcionario.repository;

import br.com.funcionario.domain.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long> {
    Optional<Salario> findByFuncionarioClt(Long funcionarioClt);

    Optional<Salario> findByFuncionarioCnpj(Long funcionarioCnpj);
}
