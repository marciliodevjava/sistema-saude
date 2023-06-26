package br.com.funcionario.repository;

import br.com.funcionario.domain.Dependente;
import br.com.funcionario.domain.FuncionarioClt;
import br.com.funcionario.domain.FuncionarioCnpj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepositry extends JpaRepository<Dependente, Long> {
   List<Dependente> findByFuncionarioClt(FuncionarioClt funcionarioClt);

    List<Dependente> findByFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj);
}
