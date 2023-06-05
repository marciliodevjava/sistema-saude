package br.com.funcionario.domain;

import br.com.funcionario.domain.enuns.EstadoFuncionarioEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "identificador_funcionario", length = 36)
    private String identificadorFuncionario;
    @Column(name = "numero_funcionario", length = 20)
    private Integer numeroFuncionario;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_funcionario", length = 15)
    private EstadoFuncionarioEnum estadoFuncionarioEnum;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private FuncionarioClt funcionarioClt;
    @Setter(onMethod = @__({@JsonProperty}))
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private FuncionarioCnpj funcionarioCnpj;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}