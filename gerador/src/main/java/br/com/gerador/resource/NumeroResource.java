package br.com.gerador.resource;

import br.com.gerador.dto.NumeroDto;
import br.com.gerador.service.NumeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;

@RestController
@RequestMapping("/gerador-numero")
public class NumeroResource {

    private URI uri;
    @Autowired
    private NumeroService numeroService;

    @GetMapping("/{id}")
    public ResponseEntity<NumeroDto> buscarNumeroId(@PathVariable @Valid Long id) {
        NumeroDto numeroRetorno = numeroService.buscarPorId(id);
        return ResponseEntity.ok(numeroRetorno);
    }

    @GetMapping("/gerar/{id}")
    public ResponseEntity<NumeroDto> gerarNumero(@PathVariable Long id, UriComponentsBuilder uriBuild) throws ParseException {
        NumeroDto numeroRetorno = numeroService.geraNumero(id);
        this.uri = uriBuild.path("/gerador-numero/{id}").buildAndExpand(numeroRetorno.getNumero()).toUri();

        return ResponseEntity.created(uri).body(numeroRetorno);
    }

    @GetMapping("/gerar-sem-id")
    public ResponseEntity<NumeroDto> gerarNumero() throws ParseException {
        NumeroDto numeroRetorno = numeroService.geraNumero();

        return ResponseEntity.ok(numeroRetorno);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<NumeroDto>> listarNumero(@PageableDefault(size = 10, sort = "id", page = 0) Pageable paginacao) {
        Page<NumeroDto> numeroRetorno = numeroService.buscarNumeros(paginacao);

        return ResponseEntity.ok(numeroRetorno);
    }

    @GetMapping("/port")
    public String retornaPort(@Value("${local.server.port}") String port) {
        return String.format("Requisição respondida pela instancia na porta %s", port);
    }
}
