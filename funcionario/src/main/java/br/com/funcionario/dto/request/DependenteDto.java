package br.com.funcionario.dto.request;

import br.com.funcionario.domain.enuns.GrauParentescoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DependenteDto {
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private GrauParentescoEnum grauParentescoEnum;
}
