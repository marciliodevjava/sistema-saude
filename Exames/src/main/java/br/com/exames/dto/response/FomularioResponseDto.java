package br.com.exames.dto.response;

import br.com.exames.dto.request.MedicoRequestDto;
import br.com.exames.dto.request.PacienteRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FomularioResponseDto {
    private Long id;
    private String identificador;
    private String data;
    private String hora;
    private MedicoRequestDto medico;
    private PacienteRequestDto paciente;
}
