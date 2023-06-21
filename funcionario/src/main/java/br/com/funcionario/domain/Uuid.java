package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.Projeto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "uuid")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Uuid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid_gerado")
    private String uuidGerado;
    @Enumerated(EnumType.STRING)
    @Column(name = "projeto", length = 20)
    private Projeto projeto;
    @Column(name = "data")
    private Date data;
    @Column(name = "hora")
    private LocalTime hora;
}

