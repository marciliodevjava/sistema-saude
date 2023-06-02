package br.com.funcionario.dto.response;

import br.com.funcionario.domain.enuns.GrauParentescoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class DependenteRetornoDto {
    private UUID identificadorEndereco;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private GrauParentescoEnum grauParentescoEnum;
}
