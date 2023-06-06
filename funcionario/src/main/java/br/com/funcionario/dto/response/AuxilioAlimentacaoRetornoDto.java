package br.com.funcionario.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class AuxilioAlimentacaoRetornoDto {
    private String identificadorAuxilioTransporte;
    private int dias;
    private BigDecimal valor;
}
