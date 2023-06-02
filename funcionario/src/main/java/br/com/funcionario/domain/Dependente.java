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
    private UUID identificadorDependente;
    private String nome;
    private String cpf;
    private String rg;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Enumerated(EnumType.STRING)
    @Column(name = "grau_parentesco")
    private GrauParentescoEnum grauParentescoEnum;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionarioClt")
    private FuncionarioClt funcionarioClt;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionarioCnpj")
    private FuncionarioCnpj funcionarioCnpj;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
