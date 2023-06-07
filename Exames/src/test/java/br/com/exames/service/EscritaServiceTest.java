package br.com.exames.service;

import br.com.exames.dto.request.FormularioRequestDto;
import br.com.exames.dto.response.FomularioResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
public class EscritaServiceTest {

    private final String DATA = "2023/06/07";
    private final String HORA = "19:06:00";
    @Autowired
    private EscritaService escritaService;

    @Test
    void salvarFormularioUnico() throws ParseException {
        FormularioRequestDto formularioRequest = this.montarFormulario();

        FomularioResponseDto formulario = escritaService.salvaFormulario(formularioRequest);

        Assertions.assertEquals(HORA, formulario.getHora());
    }

    private FormularioRequestDto montarFormulario() {

        FormularioRequestDto formularioRequestDto = new FormularioRequestDto();

        formularioRequestDto.setData(DATA);
        formularioRequestDto.setHora(HORA);

        return formularioRequestDto;
    }
}
