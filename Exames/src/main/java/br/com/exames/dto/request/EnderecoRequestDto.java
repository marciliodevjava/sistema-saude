package br.com.exames.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequestDto {
    private Long id;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;
    private Byte ativo;
}
