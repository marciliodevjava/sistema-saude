package br.com.exames.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "formulario_paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_formulario",length = 36)
    private String idFormulario;
    @Column(name = "data")
    private Date data;
    @Column(name = "hora")
    private LocalTime hora;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(optional = true, cascade = CascadeType.PERSIST, mappedBy = "formulario", fetch = FetchType.LAZY)
    private Medico medico;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToOne(optional = true, cascade = CascadeType.PERSIST, mappedBy = "formulario", fetch = FetchType.LAZY)
    private Paciente paciente;
}
