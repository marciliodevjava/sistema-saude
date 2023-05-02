package br.com.funcionario.repository;

import br.com.funcionario.domain.Salario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarioRepository extends JpaRepository<Salario, Long> {
}
