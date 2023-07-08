package br.com.exames.resource;

import br.com.exames.dto.request.FormularioRequestDto;
import br.com.exames.dto.response.FomularioResponseDto;
import br.com.exames.service.EscritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/exames")
public class EscritaResource {

    @Autowired
    private EscritaService escritaResource;

    @PostMapping()
    public ResponseEntity<FomularioResponseDto> salvaFormularioCompleto(@RequestBody FormularioRequestDto formularioRequestDto) throws ParseException {

        FomularioResponseDto response = escritaResource.salvaFormulario(formularioRequestDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FomularioResponseDto> getExanes(@PathVariable Long id) {

        FomularioResponseDto response = escritaResource.trazerFuncionario(id);

        return ResponseEntity.ok(response);
    }
}
