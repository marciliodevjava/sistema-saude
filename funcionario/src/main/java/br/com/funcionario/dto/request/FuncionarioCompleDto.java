package br.com.funcionario.dto.request;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioCompleDto {
    @NotBlank(message = "Estado Fúncionário obrigatório.")
    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    private Boolean inPrincipalFuncionarioClt;
    private FuncionarioCltDto funcionarioClt;
    private Boolean inPrincipalFuncionarioCnpj;
    private FuncionarioCnpjDto funcionarioCnpj;
}
