package br.com.funcionario.repository;

import br.com.funcionario.domain.AuxilioTransporte;
import br.com.funcionario.domain.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuxilioTransporteRepository extends JpaRepository<AuxilioTransporte, Long> {
    Optional<AuxilioTransporte> findBySalario(Salario salario);
}
