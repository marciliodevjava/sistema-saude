package br.com.exames.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_paciente", length = 36)
    private String idPaciente;
    @Column(name = "nome", length = 150)
    private String nome;
    @Column(name = "rg", length = 16)
    private String rg;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "email", length = 150)
    private String email;
    @Column(name = "crn", length = 15)
    private String crn;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    private Byte ativo;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(optional = true, cascade = CascadeType.PERSIST, mappedBy = "paciente", fetch = FetchType.LAZY)
    private Endereco endereco;
    @OneToOne
    @JoinColumn(name = "id_formulario")
    private Formulario formulario;
}
