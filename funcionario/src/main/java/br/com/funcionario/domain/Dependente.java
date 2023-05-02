package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.GrauParentescoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "depedentes")
@NoArgsConstructor
@AllArgsConstructor
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    @Enumerated(EnumType.STRING)
    private GrauParentescoEnum grauParentescoEnum;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario_clt")
    private FuncionarioClt funcionarioClt;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario_cnpj")
    private FuncionarioCnpj funcionarioCnpj;
}
