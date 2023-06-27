package br.com.funcionario.service;

import br.com.funcionario.dto.request.SalarioDto;
import br.com.funcionario.dto.response.SalarioRetornoDto;
import br.com.funcionario.service.v0.SalarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class SalarioServiceTest {

    private final Double SALARIO = 1319.00;
    private final Double AUXILIO_ALIMENTACAO = 319.00;
    private final Double AUXILIO_TRANSPORTE = 319.00;
    @Autowired
    private SalarioService salarioService;

    @Test
    public void salvarSalario(){

        SalarioDto salarioDto = this.montarSalario();

        SalarioRetornoDto salarioRetornoDto = salarioService.savarSalario(salarioDto);

        Assertions.assertEquals(null, salarioRetornoDto.getAuxilioAlimentacao());
    }

    private SalarioDto montarSalario() {

        SalarioDto salario = new SalarioDto();

        salario.setSalario(SALARIO);
        salario.setValorAlimentacao(AUXILIO_ALIMENTACAO);
        salario.setTransporte(AUXILIO_TRANSPORTE);

        return salario;
    }
}
