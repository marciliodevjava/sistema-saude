package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_funcionario", length = 20)
    private Integer numeroFuncionario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_funcionario", length = 12)
    private EstadoFuncionarioEnum estadoFuncionarioEnum;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.PERSIST)
    private FuncionarioClt funcionarioClt;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.PERSIST)
    private FuncionarioCnpj funcionarioCnpj;
}