package br.com.funcionario.dto.response;

import br.com.funcionario.domain.AuxilioAlimentacao;
import br.com.funcionario.domain.AuxilioTransporte;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class SalarioRetornoDto {
    private UUID identificadorSalario;
    private BigDecimal salario;
    private BigDecimal valorAlimentacao;
    private BigDecimal transporte;
    private AuxilioAlimentacaoRetornoDto auxilioAlimentacao;
    private AuxilioTransporteRetornoDto auxilioTransporte;
}
