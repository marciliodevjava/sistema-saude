package br.com.funcionario.dto.request;


import br.com.funcionario.domain.enuns.EstadoCivilEnum;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FuncionarioCltDto {
    @NotNull
    private FuncaoFuncionarioEnum funcaoFuncionarioEnum;
    @NotNull
    private EstadoCivilEnum estadoCivil;
    @NotNull
    private SalarioDto salario;
    @NotNull
    private String nome;
    @NotNull
    private String dataNascimento;
    @NotNull
    private String cpf;
    @NotNull
    private String rg;
    @NotNull
    private String ddd;
    @NotNull
    private String telefone;
    @NotNull
    private String email;
    @NotNull
    private String horarioInicial;
    @NotNull
    private String horarioFinal;
    private List<DependenteDto> dependentesList;
    @NotNull
    private List<EnderecoDto> endereco;
}
