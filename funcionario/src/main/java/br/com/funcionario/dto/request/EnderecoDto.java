package br.com.funcionario.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
    @NotNull(message = "E-mail do Funcionário obrigatório.")
    private String cep;
    @NotNull(message = "E-mail do Funcionário obrigatório.")
    private String logradouro;
    @NotNull(message = "Número do Funcionário obrigatório.")
    private String numero;
    @NotNull(message = "Bairro do Funcionário obrigatório.")
    private String bairro;
    @NotNull(message = "Cidade do Funcionário obrigatório.")
    private String cidade;
    @NotNull(message = "Uf do Funcionário obrigatório.")
    private String uf;
}
