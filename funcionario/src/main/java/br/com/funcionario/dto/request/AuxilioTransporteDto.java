package br.com.funcionario.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AuxilioTransporteDto {
    private int dias;
    private BigDecimal valorPassagem;

}
