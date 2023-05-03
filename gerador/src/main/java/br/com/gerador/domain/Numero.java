package br.com.gerador.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "numeros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Numero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private LocalDateTime data;
    @Column(name = "id_funcionario")
    private Long idFuncionario;
}
