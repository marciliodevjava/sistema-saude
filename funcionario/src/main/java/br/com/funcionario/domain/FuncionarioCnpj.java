package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.EstadoCivil;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionaris_cnpj")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioCnpj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "funcao_funcionario", length = 25)
    @Enumerated(EnumType.STRING)
    private FuncaoFuncionarioEnum funcaoFuncionarioEnum;

    @Column(name = "estado_civil", length = 10)
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "funcionario_cnpj")
    private Salario salario;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    private Date dataNascimento;

    private String cpf;

    private String rg;

    private String telefone;

    private String email;

    private Date dataAdmissao;

    private LocalTime horaInicial;

    private LocalTime horaFinal;

    private Boolean ativo = true;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "funcionario_cnpj")
    private List<Dependente> dependentesList = new ArrayList<>();

    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "funcionario_cnpj")
    private List<Endereco> endereco;

    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
}