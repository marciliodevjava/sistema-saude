package br.com.exames.repository;

import br.com.exames.domain.Formulario;
import br.com.exames.domain.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}
