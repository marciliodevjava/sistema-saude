package br.com.funcionario.dto;

import br.com.funcionario.domain.FuncionarioClt;
import br.com.funcionario.domain.FuncionarioCnpj;
import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.dto.request.FuncionarioCltDto;
import br.com.funcionario.dto.request.FuncionarioCnpjDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {
    private Integer numeroFuncionario;

    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    private FuncionarioCltDto funcionarioClt;
    private FuncionarioCnpjDto funcionarioCnpj;
}
