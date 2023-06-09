package br.com.funcionario.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name = "identificador_salario", length = 36)
    private String identificadorSalario;
    @Column(name = "salario")
    private BigDecimal salario;
    @Column(name = "valor_alimentacao")
    private BigDecimal valorAlimentacao;
    @Column(name = "transporte")
    private BigDecimal transporte;
    @Getter(onMethod = @__({@JsonIgnore}))
    @Setter(onMethod = @__({@JsonProperty}))
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "salario", fetch = FetchType.LAZY)
    private AuxilioAlimentacao auxilioAlimentacao;
    @Getter(onMethod = @__({@JsonIgnore}))
    @Setter(onMethod = @__({@JsonProperty}))
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "salario", fetch = FetchType.LAZY)
    private AuxilioTransporte auxilioTransporte;
    @OneToOne
    @JoinColumn(name = "id_funcionarioCnpj")
    private FuncionarioCnpj funcionarioCnpj;
    @OneToOne
    @JoinColumn(name = "id_funcionarioClt")
    private FuncionarioClt funcionarioClt;


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
