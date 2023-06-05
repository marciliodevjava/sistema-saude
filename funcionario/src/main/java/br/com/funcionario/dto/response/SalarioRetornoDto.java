package br.com.funcionario.dto.response;

import br.com.funcionario.domain.AuxilioAlimentacao;
import br.com.funcionario.domain.AuxilioTransporte;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalarioRetornoDto {
    private String identificadorSalario;
    private BigDecimal salario;
    private BigDecimal valorAlimentacao;
    private BigDecimal transporte;
    private AuxilioAlimentacaoRetornoDto auxilioAlimentacao;
    private AuxilioTransporteRetornoDto auxilioTransporte;
}
