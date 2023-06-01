package br.com.funcionario.dto.request;

import br.com.funcionario.domain.Salario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class AuxilioAlimentacaoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identificadorAuxilioTransporte;
    private int dias;
    private BigDecimal valor;
    @OneToOne
    @JoinColumn(name = "id_salarios")
    private Salario salarioCnpj;
}
