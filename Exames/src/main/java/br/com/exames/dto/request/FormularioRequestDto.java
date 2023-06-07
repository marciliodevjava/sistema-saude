package br.com.exames.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormularioRequestDto {

    private String data;
    private String hora;
    private MedicoRequestDto medico;
    private PacienteRequestDto paciente;
}
