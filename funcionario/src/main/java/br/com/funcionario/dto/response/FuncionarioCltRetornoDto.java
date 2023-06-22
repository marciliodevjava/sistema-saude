package br.com.funcionario.dto.response;

import br.com.funcionario.domain.enuns.EstadoCivilEnum;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FuncionarioCltRetornoDto {
    private Long id;
    private String identificadorFuncionarioClt;
    private FuncaoFuncionarioEnum funcaoFuncionarioEnum;
    private EstadoCivilEnum estadoCivil;
    private SalarioRetornoDto salario;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String rg;
    private String ddd;
    private String telefone;
    private String email;
    private Date dataAdmissao;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Boolean ativo;
    private List<DependenteRetornoDto> dependentesList = new ArrayList<>();
    private List<EnderecoRetornoDto> endereco = new ArrayList<>();
}
