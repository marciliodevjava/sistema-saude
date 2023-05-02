package br.com.funcionario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private Boolean ative = true;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario_clt")
    private FuncionarioClt funcionarioClt;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_funcionario_cnpj")
    private FuncionarioCnpj funcionarioCnpj;
}
