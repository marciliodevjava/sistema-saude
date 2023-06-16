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
    @Column(name = "id_funcionario")
    private Long idFuncionario;
    @Column(name = "identificador_numero", length = 36)
    private String identificadorNumero;
    @Column(name = "matricula")
    private Integer matricula;
    @Column(name = "data")
    private LocalDateTime data;
}
