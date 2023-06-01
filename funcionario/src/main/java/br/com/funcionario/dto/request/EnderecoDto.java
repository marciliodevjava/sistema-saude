package br.com.funcionario.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
}
