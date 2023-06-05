package br.com.funcionario.dto.request;

import br.com.funcionario.domain.enuns.EstadoCivilEnum;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
public class FuncionarioCnpjDto {
    @NotNull(message = "Função do Funcionário obrigatório.")
    private FuncaoFuncionarioEnum funcaoFuncionarioEnum;
    @NotNull(message = "Estado civil do Funcionário obrigatório.")
    private EstadoCivilEnum estadoCivil;
    @NotNull(message = "Salario do Funcionário obrigatório.")
    private SalarioDto salario;
    @NotNull(message = "Nome do Funcionário obrigatório.")
    private String nome;
    @NotNull(message = "Data de Nascimento do Funcionário obrigatório.")
    private String dataNascimento;
    @CPF
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF do Funcionário obrigatório.")
    @NotNull(message = "Cpf do Funcionário obrigatório.")
    private String cpf;
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "CNPJ inválido")
    @CNPJ
    @NotNull(message = "Cnpj do Funcionário obrigatório.")
    private String cnpj;
    @NotNull(message = "Rg do Funcionário obrigatório.")
    private String rg;
    @NotNull(message = "DDD do Funcionário obrigatório.")
    private String ddd;
    @NotNull(message = "Telefone do Funcionário obrigatório.")
    @Pattern(regexp = "^(\\(\\d{2}\\))?\\s?\\d{4,5}\\-\\d{4}$", message = "Telefone do Funcionário obrigatório.")
    private String telefone;
    @NotNull(message = "E-mail do Funcionário obrigatório.")
    private String email;
    @NotNull(message = "Horário inícial ex: HH:mm:ss obrigatório.")
    private String horarioInicial;
    @NotNull(message = "Horário inícial ex: HH:mm:ss obrigatório.")
    private String horarioFinal;
    private List<DependenteDto> dependentesList;
    @NotNull(message = "Éndereço do Funcionário obrigatório.")
    private List<EnderecoDto> endereco;
}
