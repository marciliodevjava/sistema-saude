package br.com.gerador.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NumeroDto {

    private Integer numero;
    private String identificadorNumero;
    private Date data;
    private Long idFuncionario;
}
