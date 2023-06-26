package br.com.funcionario.repository;

import br.com.funcionario.domain.Funcionario;
import br.com.funcionario.domain.FuncionarioCnpj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioCnpjRepository extends JpaRepository<FuncionarioCnpj, Long> {
    Optional<FuncionarioCnpj> findByFuncionario(Funcionario funcionario);
}
