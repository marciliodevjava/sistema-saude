package br.com.funcionario.repository;

import br.com.funcionario.domain.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepositry extends JpaRepository<Dependente, Long> {
    List<Dependente> findByFuncinarioClt(Long id);

    List<Dependente> findByFuncinarioCnpj(Long id);
}
