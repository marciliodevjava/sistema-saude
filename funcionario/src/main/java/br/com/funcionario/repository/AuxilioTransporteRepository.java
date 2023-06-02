package br.com.funcionario.repository;

import br.com.funcionario.domain.AuxilioTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuxilioTransporteRepository extends JpaRepository<AuxilioTransporte, Long> {
}