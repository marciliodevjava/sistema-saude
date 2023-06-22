package br.com.funcionario.dto.response;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioCompleRetornoDto {
    private String identificadorFunciona;
    private Integer matricula;
    private EstadoFuncionarioEnum situacao;
    private FuncionarioCltRetornoDto funcionarioClt;
    private FuncionarioCnpjRetornoDto funcionarioCnpj;
}
