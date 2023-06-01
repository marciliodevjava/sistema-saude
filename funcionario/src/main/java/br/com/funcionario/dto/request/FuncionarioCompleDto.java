package br.com.funcionario.dto.request;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioCompleDto {
    @NotBlank
    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    private FuncionarioCltDto funcionarioClt;
    private FuncionarioCnpjDto funcionarioCnpj;
}
