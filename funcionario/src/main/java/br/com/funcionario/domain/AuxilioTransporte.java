package br.com.funcionario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "auxilio_transporte")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuxilioTransporte implements Serializable {
    @Serial
    private static final long serialVersionUID = 7L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "identificador_auxilio_transporte", length = 36)
    private String identificadorAuxilioTransporte;
    private int dias;
    @Column(name = "valor_passagem")
    private BigDecimal valorPassagem;
    @OneToOne
    @JoinColumn(name = "id_salario")
    private Salario salario;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
