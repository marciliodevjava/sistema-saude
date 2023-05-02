package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Table(name = "funcionarios")
@Entity
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_funcionario", length = 20)
    private Integer numeroFuncionario;
    @Column(name = "estado_funcionario", length = 12)
    @Enumerated(EnumType.STRING)
    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    @Column(name = "funcionario_clt")
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "funcionario")
    private FuncionarioClt funcionarioClt;
    @Column(name = "funcionario_clt")
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "funcionario")
    private FuncionarioCnpj funcionarioCnpj;

    public Funcionario(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNumeroFuncionario(Integer numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    public void setEstadoFuncionarioEnum(EstadoFuncionarioEnum estadoFuncionarioEnum) {
        this.estadoFuncionarioEnum = estadoFuncionarioEnum;
    }

    public Integer getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setFuncionarioClt(FuncionarioClt funcionarioClt) {
        this.funcionarioClt = funcionarioClt;
    }

    public FuncionarioClt getFuncionarioClt() {
        return funcionarioClt;
    }

    public void setFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj) {
        this.funcionarioCnpj = funcionarioCnpj;
    }

    public FuncionarioCnpj getFuncionarioCnpj() {
        return funcionarioCnpj;
    }

    public EstadoFuncionarioEnum getEstadoFuncionarioEnum() {
        return estadoFuncionarioEnum;
    }
}
