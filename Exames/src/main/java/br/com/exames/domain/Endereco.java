package br.com.exames.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "enderecos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_endereco", length = 36)
    private String idEndereco;
    @Column(name = "cep", length = 8)
    private String cep;
    @Column(name = "endereco", length = 50)
    private String endereco;
    @Column(name = "numero", length = 50)
    private String numero;
    @Column(name = "bairro", length = 50)
    private String bairro;
    @Column(name = "uf", length = 50)
    private String uf;
    @Column(name = "complemento", length = 50)
    private String complemento;
    @Column(name = "ativo", length = 50)
    private Byte ativo;
    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @OneToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

}
