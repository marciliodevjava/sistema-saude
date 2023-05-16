package br.com.gerador.resource;

import br.com.gerador.dto.NumeroDto;
import br.com.gerador.service.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/gerador-numero")
public class NumeroResource {

    private URI uri;
    @Autowired
    private NumeroService numeroService;

    @GetMapping("/{id}")
    public ResponseEntity<NumeroDto> buscarNumeroId(@PathVariable Long id){
        NumeroDto numeroRetorno = numeroService.buscarPorId(id);
        return ResponseEntity.ok(numeroRetorno);
    }

    @GetMapping("/gerar/{id}")
    public ResponseEntity<NumeroDto> gerarNumero(@PathVariable Long id, UriComponentsBuilder uriBuild) {
        NumeroDto numeroRetorno = numeroService.geraNumero(id);
        this.uri = uriBuild.path("/gerador-numero/{id}").buildAndExpand(numeroRetorno.getNumero()).toUri();

        return ResponseEntity.created(uri).body(numeroRetorno);
    }

    @GetMapping("/gerar-sem-id")
    public ResponseEntity<NumeroDto> gerarNumero() {
        NumeroDto numeroRetorno = numeroService.geraNumero();

        return ResponseEntity.ok(numeroRetorno);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NumeroDto>> listarNumero() {
        List<NumeroDto> numeroRetorno = numeroService.buscarNumeros();

        return ResponseEntity.ok(numeroRetorno);
    }

    @GetMapping("/port")
    public String retornaPort(@Value("${local.server.port}") String port) {
        return String.format("Requisição respondida pela instancia na porta %s", port);
    }
}
