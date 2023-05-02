package br.com.funcionario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "salarios")
@NoArgsConstructor
@AllArgsConstructor
public class Salario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal salario;
    private BigDecimal auxilioAlimentação;
    private BigDecimal transporte;
    @OneToOne
    private FuncionarioClt funcionarioClt;
    @OneToOne
    private FuncionarioCnpj funcionarioCnpj;

    public Long getId() {
        return id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public BigDecimal getAuxilioAlimentação() {
        return auxilioAlimentação;
    }

    public BigDecimal getTransporte() {
        return transporte;
    }

    public FuncionarioClt getFuncionarioClt() {
        return funcionarioClt;
    }

    public FuncionarioCnpj getFuncionarioCnpj() {
        return funcionarioCnpj;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setAuxilioAlimentação(BigDecimal auxilioAlimentação) {
        this.auxilioAlimentação = auxilioAlimentação;
    }

    public void setTransporte(BigDecimal transporte) {
        this.transporte = transporte;
    }

    public void setFuncionarioClt(FuncionarioClt funcionarioClt) {
        this.funcionarioClt = funcionarioClt;
    }

    public void setFuncionarioCnpj(FuncionarioCnpj funcionarioCnpj) {
        this.funcionarioCnpj = funcionarioCnpj;
    }
}
