package br.com.funcionario.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConverteValor {


    public BigDecimal converteDoubleParaDecimal(Double valorPassagem) {
        return BigDecimal.valueOf(valorPassagem);
    }
}
