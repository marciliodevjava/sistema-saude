package br.com.funcionario.dto.response;

import br.com.funcionario.domain.enuns.EstadoCivilEnum;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class FuncionarioCnpjRetornoDto {
    private UUID identificadorFuncionarioCnpj;
    private FuncaoFuncionarioEnum funcaoFuncionarioEnum;
    private EstadoCivilEnum estadoCivil;
    private SalarioRetornoDto salario;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String cnpj;
    private String rg;
    private String ddd;
    private String telefone;
    private String email;
    private Date dataAdmissao;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private Boolean ativo;
    private List<DependenteRetornoDto> dependentes;
    private List<EnderecoRetornoDto> endereco;
}
