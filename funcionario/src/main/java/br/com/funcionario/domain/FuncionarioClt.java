package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.EstadoCivilEnum;
import br.com.funcionario.domain.enuns.FuncaoFuncionarioEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "funcionarios_clt")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FuncionarioClt implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identificadorFuncionarioClt;
    @Column(name = "funcao_funcionario", length = 25)
    @Enumerated(EnumType.STRING)
    private FuncaoFuncionarioEnum funcaoFuncionarioEnum;
    @Column(name = "estado_civil", length = 10)
    @Enumerated(EnumType.STRING)
    private EstadoCivilEnum estadoCivil;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(mappedBy = "funcionarioClt", cascade = CascadeType.PERSIST)
    private Salario salario;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String rg;
    private String ddd;
    private String telefone;
    private String email;
    private Date dataAdmissao;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    private Boolean ativo = true;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "funcionarioClt")
    private List<Dependente> dependentesList = new ArrayList<>();

    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "funcionarioClt")
    private List<Endereco> endereco = new ArrayList<>();

    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}