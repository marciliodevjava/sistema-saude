package br.com.funcionario.dto.response;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import br.com.funcionario.dto.request.FuncionarioCltDto;
import br.com.funcionario.dto.request.FuncionarioCnpjDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FuncionarioRetornoDto {
    private UUID identificadorFuncionario;
    private Integer numeroFuncionario;
    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    private FuncionarioCltRetornoDto funcionarioClt;
    private FuncionarioCnpjRetornoDto funcionarioCnpj;
}
