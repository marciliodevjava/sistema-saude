package br.com.funcionario.domain;

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
@Table(name = "auxilio_alimentacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuxilioAlimentacao implements Serializable {
    @Serial
    private static final long serialVersionUID = 8L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identificadorAuxilioAlimentacao;
    private int dias;
    private BigDecimal valor;
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
