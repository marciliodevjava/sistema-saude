package br.com.funcionario.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "salarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Salario implements Serializable {
    @Serial
    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identificadorSalario;
    private BigDecimal salario;
    @Column(name = "auxilio_alimentacao")
    private BigDecimal valorAlimentacao;
    private BigDecimal transporte;
    @OneToOne
    @JoinColumn(name = "id_funcionarioClt")
    private FuncionarioClt funcionarioClt;
    @OneToOne
    @JoinColumn(name = "id_funcionarioCnpj")
    private FuncionarioCnpj funcionarioCnpj;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "salario")
    private AuxilioAlimentacao auxilioAlimentacao;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "salario")
    private AuxilioTransporte auxilioTransporte;
}
