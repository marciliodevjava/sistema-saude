package br.com.funcionario.repository;

import br.com.funcionario.domain.Endereco;
import br.com.funcionario.domain.FuncionarioClt;
import br.com.funcionario.domain.FuncionarioCnpj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByFuncionarioClt(FuncionarioClt funcionarioClt);

    List<Endereco> findByFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj);
}
