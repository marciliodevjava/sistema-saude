package br.com.funcionario.dto.response;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FuncionarioRetornoDto {
    private String identificadorFuncionario;
    private Integer numeroFuncionario;
    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    private FuncionarioCltRetornoDto funcionarioClt;
    private FuncionarioCnpjRetornoDto funcionarioCnpj;
}
