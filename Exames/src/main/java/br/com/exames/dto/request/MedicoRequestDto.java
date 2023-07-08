package br.com.exames.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoRequestDto {
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String crn;
    private String dataNascimento;
    private Byte ativo;
    private EnderecoRequestDto endereco;
}
