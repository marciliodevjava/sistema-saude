package br.com.funcionario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "salarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Salario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal salario;
    @Column(name = "auxilio_alimentacao")
    private BigDecimal auxilioAlimentacao;
    private BigDecimal transporte;
    @OneToOne
    @JoinColumn(name = "id_funcionario_clt")
    private FuncionarioClt funcionarioClt;
    @OneToOne
    @JoinColumn(name = "id_funcionario_cnpj")
    private FuncionarioCnpj funcionarioCnpj;
}
