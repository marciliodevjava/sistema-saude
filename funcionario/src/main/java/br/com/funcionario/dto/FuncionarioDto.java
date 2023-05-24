package br.com.funcionario.dto;

import br.com.funcionario.domain.FuncionarioClt;
import br.com.funcionario.domain.FuncionarioCnpj;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {
    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    private FuncionarioClt funcionarioClt;
    private FuncionarioCnpj funcionarioCnpj;
}
