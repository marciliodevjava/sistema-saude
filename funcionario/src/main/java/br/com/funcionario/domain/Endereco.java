package br.com.funcionario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {

    @Serial
    private static final long serialVersionUID = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "identificador_endereco", length = 36)
    private String identificadorEndereco;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private Boolean ativo = true;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionarioClt")
    private FuncionarioClt funcionarioClt;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionarioCnpj")
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
