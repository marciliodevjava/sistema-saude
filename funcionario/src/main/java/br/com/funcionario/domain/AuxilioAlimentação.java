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
public class AuxilioAlimentação implements Serializable {
    @Serial
    private static final long serialVersionUID = 8L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identificadorAuxilioTransporte;
    private int dias;
    private BigDecimal valor;
}
