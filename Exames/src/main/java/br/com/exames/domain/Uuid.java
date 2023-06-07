package br.com.exames.domain;

import br.com.exames.domain.enuns.EnumApi;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "uuids")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Uuid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid", length = 36)
    private String uuid;
    @Column(name = "projeto", length = 18)
    @Enumerated(EnumType.STRING)
    private EnumApi enumApi;
    @Column(name = "data", length = 36)
    private Date date;
    @Column(name = "hora", length = 36)
    private LocalTime hora;
}
