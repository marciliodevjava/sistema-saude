package br.com.gerador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NumeroDto {

    private Integer numero;
    private String identificadorNumero;
    private LocalDateTime localDateTime;
    private Long idFuncionario;
}
