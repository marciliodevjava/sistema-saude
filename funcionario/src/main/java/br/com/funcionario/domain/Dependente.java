package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.GrauParentescoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "depedentes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dependente implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identificadorEndereco;
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
