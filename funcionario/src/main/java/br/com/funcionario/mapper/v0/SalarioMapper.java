package br.com.funcionario.mapper.v0;

import br.com.funcionario.domain.Salario;
import br.com.funcionario.dto.request.SalarioDto;
import br.com.funcionario.dto.response.SalarioRetornoDto;
import br.com.funcionario.utils.ConverteValor;
import br.com.funcionario.utils.GeradorUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SalarioMapper {

    @Autowired
    private GeradorUUID geradorUUID;
    @Autowired
    private ConverteValor converteValor;

    public Salario MapearSalario(SalarioDto salarioDto) {

        if (Objects.nonNull(salarioDto)){
            Salario salario = new Salario();

            salario.setIdentificadorSalario(String.valueOf(geradorUUID.getIdentificador()));
            salario.setSalario(converteValor.converteDoubleParaDecimal(salarioDto.getSalario()));
            salario.setValorAlimentacao(converteValor.converteDoubleParaDecimal(salarioDto.getValorAlimentacao()));
            salario.setTransporte(converteValor.converteDoubleParaDecimal(salarioDto.getTransporte()));

            return salario;
        }
        return null;
    }

    public SalarioRetornoDto mapeiaRetornoSalario(Salario salario) {

        if(Objects.nonNull(salario)){
            SalarioRetornoDto salarioRetornoDto = new SalarioRetornoDto();

            salarioRetornoDto.setIdentificadorSalario(salario.getIdentificadorSalario());
            salarioRetornoDto.setSalario(salario.getSalario());
            salarioRetornoDto.setValorAlimentacao(salario.getValorAlimentacao());
            salarioRetornoDto.setTransporte(salario.getTransporte());

            return salarioRetornoDto;
        }

        return null;
    }
}
