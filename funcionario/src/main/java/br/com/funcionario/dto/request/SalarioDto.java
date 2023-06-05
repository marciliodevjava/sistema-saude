package br.com.funcionario.dto.request;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalarioDto {
    @NotNull(message = "Sálario do Funcionário obrigatório.")
    private BigDecimal salario;
    @NotNull(message = "Valor Alimentação do Funcionário obrigatório.")
    private BigDecimal valorAlimentacao;
    @NotNull(message = "Transporte do Funcionário obrigatório.")
    private BigDecimal transporte;
    private AuxilioAlimentacaoDto auxilioAlimentacao;
    private AuxilioTransporteDto auxilioTransporte;
}
