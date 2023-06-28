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
    private Boolean inPrincipalFuncionarioClt;
    private FuncionarioCltRetornoDto funcionarioClt;
    private Boolean inPrincipalFuncionarioCnpj;
    private FuncionarioCnpjRetornoDto funcionarioCnpj;
}
