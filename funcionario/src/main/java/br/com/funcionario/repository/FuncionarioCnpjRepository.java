package br.com.funcionario.repository;

import br.com.funcionario.domain.FuncionarioCnpj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioCnpjRepository extends JpaRepository<FuncionarioCnpj, Long> {
}
