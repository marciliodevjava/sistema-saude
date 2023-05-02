package br.com.funcionario.repository;

import br.com.funcionario.domain.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependenteRepositry extends JpaRepository<Dependente, Long> {
}
