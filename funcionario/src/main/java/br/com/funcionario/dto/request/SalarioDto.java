package br.com.funcionario.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalarioDto {
    @NotNull
    private BigDecimal salario;
    @NotNull
    private AuxilioAlimentacaoDto auxilioAlimentacao;
    @NotNull
    private AuxilioTransporteDto auxilioTransporte;
}
