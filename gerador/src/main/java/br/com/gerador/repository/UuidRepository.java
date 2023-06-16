package br.com.gerador.repository;

import br.com.gerador.domain.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuidRepository extends JpaRepository<Uuid, Long> {
    Uuid findByuuidGerado(String uuidGerado);
}
