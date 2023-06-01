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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identificadorAuxilioTransporte;
    private int dias;
    private BigDecimal valorPassagem;
    @OneToOne
    @JoinColumn(name = "id_salarios")
    private Salario salarioCnpj;

}
