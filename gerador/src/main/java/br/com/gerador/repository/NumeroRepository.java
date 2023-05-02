package br.com.gerador.repository;

import br.com.gerador.domain.Numero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroRepository extends JpaRepository<Numero, Long> {

    Numero findTopByOrderByIdDesc();
}
